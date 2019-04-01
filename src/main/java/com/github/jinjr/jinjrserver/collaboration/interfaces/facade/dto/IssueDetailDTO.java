package com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto;

import com.github.jinjr.jinjrserver.collaboration.domain.model.Worklog;

import java.util.List;

public class IssueDetailDTO extends IssueDTO {
    private List<WorklogDTO> worklogs;

    public List<WorklogDTO> getWorklogs() {
        return worklogs;
    }

    public void setWorklogs(List<WorklogDTO> worklogs) {
        this.worklogs = worklogs;
    }
}
