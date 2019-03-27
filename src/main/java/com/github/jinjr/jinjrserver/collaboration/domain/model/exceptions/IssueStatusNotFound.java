package com.github.jinjr.jinjrserver.collaboration.domain.model.exceptions;

public class IssueStatusNotFound extends Exception {
    private Long issueStatusId;

    public IssueStatusNotFound(Long issueStatusId) {
        super();
        this.issueStatusId = issueStatusId;
    }

    public Long getIssueStatusId() {
        return issueStatusId;
    }
}
