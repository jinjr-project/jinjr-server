package com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto;

public class TimeTrackingDTO {
    private TimeExpressionDTO originalEstimate;

    private TimeExpressionDTO remainingEstimate;

    private TimeExpressionDTO timeSpent;

    public TimeTrackingDTO(TimeExpressionDTO originalEstimate, TimeExpressionDTO remainingEstimate,
                           TimeExpressionDTO timeSpent) {
        this.originalEstimate = originalEstimate;
        this.remainingEstimate = remainingEstimate;
        this.timeSpent = timeSpent;
    }

    public TimeExpressionDTO getOriginalEstimate() {
        return originalEstimate;
    }

    public TimeExpressionDTO getRemainingEstimate() {
        return remainingEstimate;
    }

    public TimeExpressionDTO getTimeSpent() {
        return timeSpent;
    }
}
