package com.github.jinjr.jinjrserver.collaboration.interfaces.facade;

import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.IssueCreationDTO;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.IssueDTO;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.SprintDTO;

import java.util.List;

public interface IssueServiceFacade {
    IssueDTO createNewIssue(IssueCreationDTO issue);

    List<SprintDTO> loadSprints();
}
