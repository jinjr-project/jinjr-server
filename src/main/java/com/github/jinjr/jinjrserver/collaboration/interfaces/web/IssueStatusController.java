package com.github.jinjr.jinjrserver.collaboration.interfaces.web;

import com.github.jinjr.jinjrserver.collaboration.domain.model.IssueStatus;
import com.github.jinjr.jinjrserver.collaboration.domain.model.IssueStatusRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IssueStatusController {

    private IssueStatusRepository issueStatusRepository;

    public IssueStatusController(IssueStatusRepository issueStatusRepository) {
        this.issueStatusRepository = issueStatusRepository;
    }

    @GetMapping("/issue/status")
    public List<IssueStatus> loadIssueStatuses() {
        List<IssueStatus> issueStatuses = new ArrayList<>();
        for (IssueStatus issueStatus : issueStatusRepository.findAll()) {
            issueStatuses.add(issueStatus);
        }
        return issueStatuses;
    }
}
