package com.github.jinjr.jinjrserver.collaboration.interfaces.facade.internal;

import com.github.jinjr.jinjrserver.collaboration.application.IssueService;
import com.github.jinjr.jinjrserver.collaboration.domain.model.Issue;
import com.github.jinjr.jinjrserver.collaboration.domain.model.Sprint;
import com.github.jinjr.jinjrserver.collaboration.domain.model.SprintRepository;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.IssueServiceFacade;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.IssueCreationDTO;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.IssueDTO;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.SprintDTO;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.internal.assembler.IssueDTOAssembler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IssueServiceFacadeImpl implements IssueServiceFacade {

    private IssueService issueService;

    private IssueDTOAssembler issueDTOAssembler;

    private SprintRepository sprintRepository;

    public IssueServiceFacadeImpl(IssueService issueService, IssueDTOAssembler issueDTOAssembler, SprintRepository sprintRepository) {
        this.issueService = issueService;
        this.issueDTOAssembler = issueDTOAssembler;
        this.sprintRepository = sprintRepository;
    }

    @Override
    public IssueDTO createNewIssue(IssueCreationDTO dto) {
        Issue issue = issueService.createNewIssue(issueDTOAssembler.fromDTO(dto));
        return issueDTOAssembler.toDto(issue);
    }

    @Override
    public List<SprintDTO> loadSprints() {
        List<SprintDTO> dtoList = new ArrayList<>();
        for (Sprint sprint : sprintRepository.findAll()) {
            dtoList.add(new SprintDTO(sprint.getId(), sprint.getName(), issueDTOAssembler.toDTOList(sprint.getIssues())));
        }

        return dtoList;
    }
}
