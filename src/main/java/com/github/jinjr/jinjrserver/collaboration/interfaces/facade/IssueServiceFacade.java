package com.github.jinjr.jinjrserver.collaboration.interfaces.facade;

import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.IssueCreationDTO;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.IssueDTO;

public interface IssueServiceFacade {
    IssueDTO createNewIssue(IssueCreationDTO issue);
}
