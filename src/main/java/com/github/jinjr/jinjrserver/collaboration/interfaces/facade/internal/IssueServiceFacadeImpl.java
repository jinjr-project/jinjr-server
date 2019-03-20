package com.github.jinjr.jinjrserver.collaboration.interfaces.facade.internal;

import com.github.jinjr.jinjrserver.collaboration.application.IssueService;
import com.github.jinjr.jinjrserver.collaboration.domain.model.Issue;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.IssueServiceFacade;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.IssueCreationDTO;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.IssueDTO;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.internal.assembler.IssueDTOAssembler;
import org.springframework.stereotype.Component;

@Component
public class IssueServiceFacadeImpl implements IssueServiceFacade {

    private IssueService issueService;

    private IssueDTOAssembler issueDTOAssembler;

    public IssueServiceFacadeImpl(IssueService issueService) {
        this.issueService = issueService;
        issueDTOAssembler = new IssueDTOAssembler();
    }

    @Override
    public IssueDTO createNewIssue(IssueCreationDTO dto) {
        Issue issue = new Issue();
        issue.setSummary(dto.getSummary());

        issue = issueService.createNewIssue(issue);
        return issueDTOAssembler.toDto(issue);
    }
}
