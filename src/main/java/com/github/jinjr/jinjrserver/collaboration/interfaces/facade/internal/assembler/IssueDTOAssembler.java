package com.github.jinjr.jinjrserver.collaboration.interfaces.facade.internal.assembler;

import com.github.jinjr.jinjrserver.collaboration.domain.model.Issue;
import com.github.jinjr.jinjrserver.collaboration.domain.model.Sprint;
import com.github.jinjr.jinjrserver.collaboration.domain.model.SprintRepository;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.IssueCreationDTO;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.IssueDTO;
import org.springframework.stereotype.Component;

@Component
public class IssueDTOAssembler {

    private SprintRepository sprintRepository;

    public IssueDTOAssembler(SprintRepository sprintRepository) {
        this.sprintRepository = sprintRepository;
    }

    public Issue fromDTO(IssueCreationDTO dto) {
        Sprint sprint = sprintRepository.findAndCreateByName("Default");
        Issue issue = new Issue();
        sprint.assignIssue(issue);
        issue.setSummary(dto.getSummary());

        return issue;
    }

    public IssueDTO toDto(Issue issue) {
        IssueDTO dto = new IssueDTO();
        dto.setId(issue.getId());
        dto.setSummary(issue.getSummary());
        dto.setCreatedAt(issue.getCreatedAt());
        dto.setUpdatedAt(issue.getUpdatedAt());

        return dto;
    }
}
