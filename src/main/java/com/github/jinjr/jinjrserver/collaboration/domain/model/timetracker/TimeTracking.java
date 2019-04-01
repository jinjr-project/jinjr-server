package com.github.jinjr.jinjrserver.collaboration.domain.model.timetracker;

import javax.persistence.*;

@Embeddable
public class TimeTracking {

    @AttributeOverrides(value = {
            @AttributeOverride(name = "seconds", column = @Column(name = "original_estimate_seconds"))
    })
    private TimeExpression originalEstimate;

//    @AttributeOverrides(value = {
//            @AttributeOverride(name = "seconds", column = @Column(name = "spent_time_seconds"))
//    })
//    private TimeExpression spentTime;


    @AttributeOverrides(value = {
            @AttributeOverride(name = "seconds", column = @Column(name = "remaining_estimate_seconds"))
    })
    private TimeExpression remainingEstimate;

    public TimeTracking() {}

    public TimeTracking(TimeExpression originalEstimate, TimeExpression remainingEstimate) {
        this.originalEstimate = originalEstimate;
        this.remainingEstimate = remainingEstimate;
    }

    public TimeExpression getOriginalEstimate() {
        return originalEstimate;
    }

    public void setOriginalEstimate(TimeExpression originalEstimate) {
        this.originalEstimate = originalEstimate;
    }

    public TimeExpression getRemainingEstimate() {
        return remainingEstimate;
    }

    public void setRemainingEstimate(TimeExpression remainingEstimate) {
        this.remainingEstimate = remainingEstimate;
    }

    public void spentTime(TimeExpression spent, TimeExpression remaining) {
        originalEstimate = originalEstimate.add(remaining).add(spent);
        remainingEstimate = originalEstimate.reduce(spent);
    }
}
