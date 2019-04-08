package com.github.jinjr.jinjrserver.collaboration.interfaces.facade.internal;

import com.github.jinjr.jinjrserver.collaboration.application.IssueService;
import com.github.jinjr.jinjrserver.collaboration.domain.model.*;
import com.github.jinjr.jinjrserver.collaboration.domain.model.exceptions.IssueNotFound;
import com.github.jinjr.jinjrserver.collaboration.domain.model.exceptions.IssueStatusNotFound;
import com.github.jinjr.jinjrserver.collaboration.domain.model.timetracker.TimeExpression;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.IssueServiceFacade;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.*;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.internal.assembler.IssueDTOAssembler;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.internal.assembler.WorklogDTOAssembler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class IssueServiceFacadeImpl implements IssueServiceFacade {
    private IssueRepository issueRepository;

    private IssueStatusRepository issueStatusRepository;

    private IssueService issueService;

    private IssueDTOAssembler issueDTOAssembler;

    private SprintRepository sprintRepository;

    private WorklogDTOAssembler worklogDTOAssembler;

    private WorklogRepository worklogRepository;

    public IssueServiceFacadeImpl(IssueRepository issueRepository, IssueStatusRepository issueStatusRepository,
                                  IssueService issueService, IssueDTOAssembler issueDTOAssembler,
                                  SprintRepository sprintRepository, WorklogRepository worklogRepository) {

        this.issueRepository = issueRepository;
        this.issueStatusRepository = issueStatusRepository;
        this.issueService = issueService;
        this.issueDTOAssembler = issueDTOAssembler;
        this.sprintRepository = sprintRepository;
        this.worklogRepository = worklogRepository;
        this.worklogDTOAssembler = new WorklogDTOAssembler();
    }

    @Override
    public IssueDetailDTO loadIssue(Long id) throws IssueNotFound {
        Optional<Issue> issueOptional = issueRepository.findById(id);
        issueOptional.orElseThrow(() -> new IssueNotFound(id));

        return issueDTOAssembler.toIssueDetailDto(issueOptional.get());
    }

    @Override
    public IssueDTO createNewIssue(IssueCreationDTO dto) {
        Issue issue = issueService.createNewIssue(issueDTOAssembler.fromDTO(dto));
        return issueDTOAssembler.toDto(issue);
    }

    @Override
    public IssueDTO updateIssue(IssueUpdateDTO issueUpdateDTO) {

        Issue issue = issueDTOAssembler.fromDTO(issueUpdateDTO);
        issueService.updateIssue(issue);
        return issueDTOAssembler.toDto(issue);
    }

    @Override
    public IssueDTO changeIssueSummary(Long id, String summary) throws IssueNotFound {
        Optional<Issue> issue = issueRepository.findById(id);
        issue.orElseThrow(() -> new IssueNotFound(id));


        issue.get().setSummary(summary);
        issueRepository.save(issue.get());

        return issueDTOAssembler.toDto(issue.get());
    }

    @Override
    public IssueDTO changeIssueStatus(Long id, Long statusId) throws IssueStatusNotFound, IssueNotFound {
        Optional<Issue> issueOptional = issueRepository.findById(id);
        issueOptional.orElseThrow(() -> new IssueNotFound(id));

        Optional<IssueStatus> issueStatusOptional = issueStatusRepository.findById(statusId);
        issueStatusOptional.orElseThrow(() -> new IssueStatusNotFound(statusId));

        Issue issue = issueOptional.get();
        IssueStatus issueStatus = issueStatusOptional.get();

        issue.setStatus(issueStatus);
        issueRepository.save(issue);

        return issueDTOAssembler.toDto(issue);
    }

    @Override
    public WorklogCreatedDTO addWorklog(WorklogCreationDTO worklogCreation) throws IssueNotFound {

        Optional<Issue> issueOptional = issueRepository.findById(worklogCreation.getIssueId());
        issueOptional.orElseThrow(() -> new IssueNotFound(worklogCreation.getIssueId()));

        Issue issue = issueOptional.get();
        Worklog worklog = worklogDTOAssembler.fromDto(worklogCreation);

        issueService.spentTimeForIusse(worklog, issue, new TimeExpression(worklogCreation.getRemaining()));

        return worklogDTOAssembler.toDto(worklog);
    }

    @Override
    public List<SprintDTO> loadSprints() {
        List<SprintDTO> dtoList = new ArrayList<>();
        for (Sprint sprint : sprintRepository.findAll()) {
            dtoList.add(new SprintDTO(sprint.getId(), sprint.getName(), sprint.getTodo(),
                    issueDTOAssembler.toDTOList(sprint.getIssues())));
        }

        return dtoList;
    }
}
