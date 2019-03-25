package com.github.jinjr.jinjrserver.collaboration.interfaces.web;

import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.IssueServiceFacade;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.IssueCreationDTO;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.IssueDTO;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.IssueUpdateDTO;
import com.github.jinjr.jinjrserver.collaboration.interfaces.web.assembler.IssueCommandAssembler;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class IssueController {

    private IssueServiceFacade issueServiceFacade;

    private IssueCommandAssembler assembler;

    public IssueController(IssueServiceFacade issueServiceFacade) {
        this.issueServiceFacade = issueServiceFacade;
        this.assembler = new IssueCommandAssembler();
    }

    @PostMapping("/issue")
    public IssueDTO createNewIssue(@RequestBody @Valid IssueCommand command) {
        IssueCreationDTO issueCreationDTO = new IssueCreationDTO(command.getSummary());
        return issueServiceFacade.createNewIssue(issueCreationDTO);
    }

    @PutMapping("/issue/{id}")
    public IssueDTO updateIssue(@PathVariable Long id, @RequestBody @Valid IssueUpdateCommand command) {
        command.setId(id);
        return issueServiceFacade.updateIssue(assembler.toDTO(command));
    }
}
