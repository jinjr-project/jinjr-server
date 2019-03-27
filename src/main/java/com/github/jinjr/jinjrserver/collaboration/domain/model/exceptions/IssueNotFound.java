package com.github.jinjr.jinjrserver.collaboration.domain.model.exceptions;

public class IssueNotFound extends Exception {
    private Long issueId;

    public IssueNotFound(Long issueId) {
        super();

        this.issueId = issueId;
    }

    public Long getIssueId() {
        return issueId;
    }
}
