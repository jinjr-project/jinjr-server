package com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto;

import com.github.jinjr.jinjrserver.collaboration.domain.model.timetracker.TimeExpression;

import java.util.Date;

public class WorklogCreatedDTO {
    private Long id;

    private IssueDTO issue;

    private TimeExpressionDTO timeSpent;

    private String content;

    private Date startedAt;

    private Date createdAt;

    private Date updatedAt;

    public WorklogCreatedDTO(Long id, IssueDTO issue, TimeExpressionDTO timeSpent, String content, Date startedAt, Date createdAt, Date updatedAt) {
        this.id = id;
        this.issue = issue;
        this.timeSpent = timeSpent;
        this.content = content;
        this.startedAt = startedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public IssueDTO getIssue() {
        return issue;
    }

    public TimeExpressionDTO getTimeSpent() {
        return timeSpent;
    }

    public String getContent() {
        return content;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    static public class IssueDTO {
        private Long id;

        private TimeTrackingDTO timeTracking;

        public IssueDTO(Long id, TimeTrackingDTO timeTracking) {
            this.id = id;
            this.timeTracking = timeTracking;
        }

        public Long getId() {
            return id;
        }

        public TimeTrackingDTO getTimeTracking() {
            return timeTracking;
        }
    }
}
