package com.github.jinjr.jinjrserver.collaboration.domain.model.timetracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeExpression {

    private String expression;

    private Long seconds;

    private Logger logger = LoggerFactory.getLogger(TimeExpression.class);

    final private Long MINUTE = 60L;

    final private Long HOUR = MINUTE * 60L;

    final private Long DAY = HOUR * 24L;

    final private Long WEEK = DAY * 7L;

    final private Long YEAR = DAY * 365L;

    public TimeExpression(String expression) {
        this.expression = expression;
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
                default: {
                    logger.warn("invalid flag {}", flag);
                }
            }
        }
    }
}
