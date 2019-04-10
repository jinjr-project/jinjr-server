package com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto;

import com.github.jinjr.jinjrserver.collaboration.domain.model.activity.ActivityType;

import java.util.Date;

public class ActivityDTO {

    private Long id;

    private ActivityType type;

    private String summary;

    private String changedSummary;

    private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ActivityType getType() {
        return type;
    }

    public void setType(ActivityType type) {
        this.type = type;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getChangedSummary() {
        return changedSummary;
    }

    public void setChangedSummary(String changedSummary) {
        this.changedSummary = changedSummary;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
