package com.github.jinjr.jinjrserver.collaboration.domain.model.timetracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class TimeExpression {

    @Transient
    private String expression;

    @Column
    private Long seconds;

    @Transient
    private Logger logger = LoggerFactory.getLogger(TimeExpression.class);

    final private static Long MINUTE = 60L;

    final private static Long HOUR = MINUTE * 60L;

    final private static Long DAY = HOUR * 24L;

    final private static Long WEEK = DAY * 7L;

    final private static Long YEAR = DAY * 365L;

    public TimeExpression() { }

    public TimeExpression(String expression) {
        this.expression = expression;

        calculateSeconds();
    }

    public TimeExpression(Long seconds) {
        this.seconds = seconds;

        calculateExpression();
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
        calculateSeconds();
    }

    public Long getSeconds() {
        if (null == seconds) {
            calculateSeconds();
        }
        return seconds;
    }

    public void setSeconds(Long seconds) {
        this.seconds = seconds;
    }

    private void calculateExpression() {
        StringBuilder sb = new StringBuilder();
        if (seconds / DAY >= 1) {
            sb.append((seconds / DAY) + "d");
        }

        expression = sb.toString();
    }

    private void calculateSeconds() {
        Pattern pattern = Pattern.compile("(\\d+)(\\w)");
        Matcher matcher = pattern.matcher(expression);
        seconds = 0L;

        while (matcher.find()) {
            MatchResult matchResult = matcher.toMatchResult();
            int count = matchResult.groupCount();
            Long numbers = new Long(matchResult.group(1));
            String flag = matchResult.group(2);

            switch (flag) {
                case "y": {
                    seconds += numbers * YEAR;
                    break;
                }
                case "w": {
                    seconds += numbers * WEEK;
                    break;
                }
                case "d": {
                    seconds += numbers * DAY;
                    break;
                }
                case "h": {
                    seconds += numbers * HOUR;
                    break;
                }
                case "m": {
                    seconds += numbers * MINUTE;
                    break;
                }
                case "s": {
                    seconds += numbers;
                    break;
                }
                default: {
                    logger.warn("invalid flag {}", flag);
                }
            }
        }
    }

    public TimeExpression add(TimeExpression time) {
        if (null == seconds) {
            calculateSeconds();
        }

        TimeExpression cloned = new TimeExpression(seconds + time.getSeconds());
        cloned.calculateExpression();

        return cloned;
    }

    public TimeExpression reduce(TimeExpression reduceTime) {
        return add(new TimeExpression(-reduceTime.getSeconds()));
    }

    @Override
    public TimeExpression clone() {
        return new TimeExpression(seconds);
    }
}
