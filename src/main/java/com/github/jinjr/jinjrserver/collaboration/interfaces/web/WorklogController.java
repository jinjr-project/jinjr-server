package com.github.jinjr.jinjrserver.collaboration.interfaces.web;

import com.github.jinjr.jinjrserver.collaboration.domain.model.exceptions.IssueNotFound;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.IssueServiceFacade;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.WorklogCreationDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorklogController {

    private IssueServiceFacade issueServiceFacade;

    public WorklogController(IssueServiceFacade issueServiceFacade) {
        this.issueServiceFacade = issueServiceFacade;
    }

    @PostMapping("/issue/{id}/worklog")
    public void addWorklog(@PathVariable Long id, WorklogCreationCommand command) throws IssueNotFound {
        issueServiceFacade.addWorklog(new WorklogCreationDTO(
                id, command.getSpent(), command.getRemaining(), command.getContent(), command.getStarted()
        ));
    }
}
