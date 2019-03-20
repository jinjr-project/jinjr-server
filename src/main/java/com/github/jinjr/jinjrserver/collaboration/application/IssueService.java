package com.github.jinjr.jinjrserver.collaboration.application;

import com.github.jinjr.jinjrserver.collaboration.domain.model.Issue;

public interface IssueService {
    Issue createNewIssue(Issue issue);
}
