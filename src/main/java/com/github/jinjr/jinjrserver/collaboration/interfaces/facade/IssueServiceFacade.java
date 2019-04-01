package com.github.jinjr.jinjrserver.collaboration.interfaces.facade;

import com.github.jinjr.jinjrserver.collaboration.domain.model.exceptions.IssueNotFound;
import com.github.jinjr.jinjrserver.collaboration.domain.model.exceptions.IssueStatusNotFound;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.*;

import java.util.List;

public interface IssueServiceFacade {
    IssueDTO createNewIssue(IssueCreationDTO issue);

    IssueDTO updateIssue(IssueUpdateDTO issueUpdateDTO);

    IssueDTO changeIssueSummary(Long id, String summary) throws IssueNotFound;

    IssueDTO changeIssueStatus(Long id, Long statusId) throws IssueStatusNotFound, IssueNotFound;

    WorklogCreatedDTO addWorklog(WorklogCreationDTO worklogCreation) throws IssueNotFound;

    List<SprintDTO> loadSprints();
}
