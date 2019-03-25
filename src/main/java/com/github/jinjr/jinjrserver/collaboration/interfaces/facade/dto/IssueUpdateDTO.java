package com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto;

public class IssueUpdateDTO {
    private Long id;

    private String summary;

    private Long statusId;

    public IssueUpdateDTO(Long id, String summary, Long statusId) {
        this.id = id;
        this.summary = summary;
        this.statusId = statusId;
    }

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
