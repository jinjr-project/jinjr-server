package com.github.jinjr.jinjrserver.collaboration.interfaces.web;

import javax.validation.constraints.NotEmpty;

public class IssueUpdateCommand {
    private Long id;

    @NotEmpty
    private String summary;

    private Long statusId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }
}
