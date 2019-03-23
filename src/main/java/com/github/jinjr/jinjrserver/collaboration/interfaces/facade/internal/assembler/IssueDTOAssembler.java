package com.github.jinjr.jinjrserver.collaboration.interfaces.facade.internal.assembler;

import com.github.jinjr.jinjrserver.collaboration.domain.model.*;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.IssueCreationDTO;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.IssueDTO;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.IssueUpdateDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class IssueDTOAssembler {

    private SprintRepository sprintRepository;

    private IssueRepository issueRepository;

    private IssueStatusRepository issueStatusRepository;

    public IssueDTOAssembler(SprintRepository sprintRepository, IssueRepository issueRepository, IssueStatusRepository issueStatusRepository) {
        this.sprintRepository = sprintRepository;
        this.issueRepository = issueRepository;
        this.issueStatusRepository = issueStatusRepository;
    }

    public Issue fromDTO(IssueCreationDTO dto) {
        Sprint sprint = sprintRepository.findAndCreateByName("Default");
        IssueStatus issueStatus = issueStatusRepository.findById(1L).get();

        Issue issue = new Issue();
        sprint.assignIssue(issue);
        issue.setStatus(issueStatus);
        issue.setSummary(dto.getSummary());

        return issue;
    }

    public Issue fromDTO(IssueUpdateDTO dto) {

        Optional<Issue> optionalIssue = issueRepository.findById(dto.getId());
        Issue issue = optionalIssue.get();

        if (dto.getStatusId() != null) {
            Optional<IssueStatus> status = issueStatusRepository.findById(dto.getStatusId());
            issue.setStatus(status.get());
        }

        if (dto.getSummary() != null) {
            issue.setSummary(dto.getSummary());
        }

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

    public List<IssueDTO> toDTOList(List<Issue> issues) {
        List<IssueDTO> dtoList = new ArrayList<>();

        for (Issue issue : issues) {
            dtoList.add(toDto(issue));
        }

        return dtoList;
    }
}
