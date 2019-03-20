package com.github.jinjr.jinjrserver.collaboration.application.impl;

import com.github.jinjr.jinjrserver.collaboration.application.IssueService;
import com.github.jinjr.jinjrserver.collaboration.domain.model.Issue;
import com.github.jinjr.jinjrserver.collaboration.domain.model.IssueRepository;
import org.springframework.stereotype.Service;

@Service
public class IssueServiceImpl implements IssueService {

    private IssueRepository repository;

    public IssueServiceImpl(IssueRepository repository) {
        this.repository = repository;
    }

    @Override
    public Issue createNewIssue(Issue issue) {
        repository.save(issue);
        return issue;
    }
}
