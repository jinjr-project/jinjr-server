package com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto;

import java.util.List;

public class IssueDetailDTO extends IssueDTO {
    private List<WorklogDTO> worklogs;

    private TimeTrackingDTO timeTracking;

    public IssueDetailDTO(List<WorklogDTO> worklogs, TimeTrackingDTO timeTracking) {
        this.worklogs = worklogs;
        this.timeTracking = timeTracking;
    }

    public List<WorklogDTO> getWorklogs() {
        return worklogs;
    }

    public TimeTrackingDTO getTimeTracking() {
        return timeTracking;
    }
}
