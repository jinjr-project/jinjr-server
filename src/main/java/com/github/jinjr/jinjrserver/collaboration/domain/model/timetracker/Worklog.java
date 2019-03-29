package com.github.jinjr.jinjrserver.collaboration.domain.model.timetracker;

import javax.persistence.Entity;
import java.util.Date;

//@Entity
public class Worklog {

    private Long id;

    private String comment;

    private TimeExpression timeSpent;

    private Date startedAt;

    private Date updatedAt;

    private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public TimeExpression getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(TimeExpression timeSpent) {
        this.timeSpent = timeSpent;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
