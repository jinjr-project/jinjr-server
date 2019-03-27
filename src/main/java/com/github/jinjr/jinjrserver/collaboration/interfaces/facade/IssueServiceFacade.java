package com.github.jinjr.jinjrserver.collaboration.interfaces.facade;

import com.github.jinjr.jinjrserver.collaboration.domain.model.exceptions.IssueNotFound;
import com.github.jinjr.jinjrserver.collaboration.domain.model.exceptions.IssueStatusNotFound;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.IssueCreationDTO;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.IssueDTO;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.IssueUpdateDTO;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.SprintDTO;

import java.util.List;

public interface IssueServiceFacade {
    IssueDTO createNewIssue(IssueCreationDTO issue);

    IssueDTO updateIssue(IssueUpdateDTO issueUpdateDTO);

    IssueDTO changeIssueSummary(Long id, String summary) throws IssueNotFound;

    IssueDTO changeIssueStatus(Long id, Long statusId) throws IssueStatusNotFound, IssueNotFound;

    List<SprintDTO> loadSprints();
}
