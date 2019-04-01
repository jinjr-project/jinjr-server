package com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto;

public class TimeExpressionDTO {

    private String expression;

    private Long seconds;

    public TimeExpressionDTO(String expression, Long seconds) {
        this.expression = expression;
        this.seconds = seconds;
    }

    public String getExpression() {
        return expression;
    }

    public Long getSeconds() {
        return seconds;
    }
}
