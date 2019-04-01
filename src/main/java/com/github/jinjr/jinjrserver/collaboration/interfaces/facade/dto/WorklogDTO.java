package com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto;

import java.util.Date;

public class WorklogDTO {
    private Long id;

    private String content;

    private TimeExpressionDTO spentTime;

    private Date startedAt;

    private Date createdAt;

    private Date updatedAt;


    public WorklogDTO(Long id, String content, TimeExpressionDTO spentTime, Date startedAt, Date createdAt, Date updatedAt) {
        this.id = id;
        this.content = content;
        this.spentTime = spentTime;
        this.startedAt = startedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TimeExpressionDTO getSpentTime() {
        return spentTime;
    }

    public void setSpentTime(TimeExpressionDTO spentTime) {
        this.spentTime = spentTime;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
