package com.github.jinjr.jinjrserver.collaboration.interfaces.web;

import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.IssueServiceFacade;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.IssueCreationDTO;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.IssueDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class IssueController {

    private IssueServiceFacade issueServiceFacade;

    public IssueController(IssueServiceFacade issueServiceFacade) {
        this.issueServiceFacade = issueServiceFacade;
    }

    @PostMapping("/issue")
    public IssueDTO createNewIssue(@RequestBody @Valid IssueCommand command) {
        IssueCreationDTO issueCreationDTO = new IssueCreationDTO(command.getSummary());
        return issueServiceFacade.createNewIssue(issueCreationDTO);
    }
}
