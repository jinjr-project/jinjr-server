package com.github.jinjr.jinjrserver.collaboration.interfaces.web;

import com.github.jinjr.jinjrserver.collaboration.domain.model.IssueStatus;
import com.github.jinjr.jinjrserver.collaboration.domain.model.exceptions.IssueNotFound;
import com.github.jinjr.jinjrserver.collaboration.domain.model.exceptions.IssueStatusNotFound;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.IssueServiceFacade;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.IssueCreationDTO;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.IssueDTO;
import com.github.jinjr.jinjrserver.collaboration.interfaces.web.assembler.IssueCommandAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/issue/{id}/summary")
    public ResponseEntity<IssueDTO> changeSummary(@PathVariable Long id, @RequestBody @Valid IssueSummaryCommand command) {
        try {
            return ResponseEntity.ok(issueServiceFacade.changeIssueSummary(id, command.getSummary()));
        } catch (IssueNotFound issueNotFound) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/issue/{id}/status")
    public ResponseEntity<IssueDTO> changeStatus(@PathVariable Long id, @RequestParam(name = "status_id") Long statusId) {
        try {
            return ResponseEntity.ok(issueServiceFacade.changeIssueStatus(id, statusId));
        } catch (IssueStatusNotFound issueNotFound) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IssueNotFound issueNotFound) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
