package com.github.jinjr.jinjrserver.collaboration.application;

import com.github.jinjr.jinjrserver.collaboration.domain.model.Issue;
import com.github.jinjr.jinjrserver.collaboration.domain.model.Worklog;
import com.github.jinjr.jinjrserver.collaboration.domain.model.timetracker.TimeExpression;

public interface IssueService {
    Issue createNewIssue(Issue issue);

    void updateIssue(Issue issue);

    Worklog spentTimeForIusse(Worklog worklog, Issue issue, TimeExpression remaining);
}
