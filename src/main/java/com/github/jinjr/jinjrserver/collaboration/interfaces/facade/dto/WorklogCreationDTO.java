package com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto;

import java.util.Date;

public class WorklogCreationDTO {
    private Long issueId;

    private String timeSpend;

    private String remaining;

    private String content;

    private Date started;

    public WorklogCreationDTO(Long issueId, String timeSpend, String remaining, String content, Date started) {
        this.issueId = issueId;
        this.timeSpend = timeSpend;
        this.remaining = remaining;
        this.content = content;
        this.started = started;
    }

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public String getTimeSpend() {
        return timeSpend;
    }

    public void setTimeSpend(String timeSpend) {
        this.timeSpend = timeSpend;
    }

    public String getRemaining() {
        return remaining;
    }

    public void setRemaining(String remaining) {
        this.remaining = remaining;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getStarted() {
        return started;
    }

    public void setStarted(Date started) {
        this.started = started;
    }
}
