package com.github.jinjr.jinjrserver.collaboration.application.impl;

import com.github.jinjr.jinjrserver.collaboration.application.IssueService;
import com.github.jinjr.jinjrserver.collaboration.domain.model.Issue;
import com.github.jinjr.jinjrserver.collaboration.domain.model.IssueRepository;
import com.github.jinjr.jinjrserver.collaboration.domain.model.Worklog;
import com.github.jinjr.jinjrserver.collaboration.domain.model.WorklogRepository;
import com.github.jinjr.jinjrserver.collaboration.domain.model.events.WorklogCreatedEvent;
import com.github.jinjr.jinjrserver.collaboration.domain.model.timetracker.TimeExpression;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IssueServiceImpl implements IssueService {

    private IssueRepository repository;

    private WorklogRepository worklogRepository;

    private ApplicationEventPublisher applicationEventPublisher;

    public IssueServiceImpl(IssueRepository repository, WorklogRepository worklogRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.repository = repository;
        this.worklogRepository = worklogRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public Issue createNewIssue(Issue issue) {
        repository.save(issue);
        return issue;
    }

    @Override
    public void updateIssue(Issue issue) {
        repository.save(issue);
    }

    @Transactional
    @Override
    public Worklog spentTimeForIusse(Worklog worklog, Issue issue, TimeExpression remaining) {

        issue.spentTime(worklog, remaining);
        worklogRepository.save(worklog);

        applicationEventPublisher.publishEvent(new WorklogCreatedEvent(worklog));
        return worklog;
    }
}
