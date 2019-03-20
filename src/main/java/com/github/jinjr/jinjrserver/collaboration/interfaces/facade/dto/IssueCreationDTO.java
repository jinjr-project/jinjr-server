package com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto;

public class IssueCreationDTO {

    private String summary;

    public IssueCreationDTO(String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
    }
}
