package com.github.jinjr.jinjrserver.collaboration.interfaces.web;

import com.github.jinjr.jinjrserver.collaboration.domain.model.Worklog;
import com.github.jinjr.jinjrserver.collaboration.domain.model.exceptions.IssueNotFound;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.IssueServiceFacade;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.WorklogCreatedDTO;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.WorklogCreationDTO;
import com.github.jinjr.jinjrserver.collaboration.interfaces.web.commands.WorklogCreationCommand;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
public class WorklogController {

    private IssueServiceFacade issueServiceFacade;

    public WorklogController(IssueServiceFacade issueServiceFacade) {
        this.issueServiceFacade = issueServiceFacade;
    }

    @PostMapping("/issue/{id}/worklog")
    public WorklogCreatedDTO addWorklog(@PathVariable Long id, @RequestBody WorklogCreationCommand command) throws IssueNotFound {
        return issueServiceFacade.addWorklog(new WorklogCreationDTO(
                id, command.getSpent(), command.getRemaining(), command.getContent(), command.getStarted()
        ));
    }

    @GetMapping("/issue/{id}/worklog")
    public Page<Worklog> loadWorklogs(@PathVariable Long issueId) throws IssueNotFound {
        return null;
    }
}
