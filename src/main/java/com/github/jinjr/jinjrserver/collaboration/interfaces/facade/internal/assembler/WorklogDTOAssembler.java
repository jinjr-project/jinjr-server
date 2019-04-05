package com.github.jinjr.jinjrserver.collaboration.interfaces.facade.internal.assembler;

import com.github.jinjr.jinjrserver.collaboration.domain.model.Worklog;
import com.github.jinjr.jinjrserver.collaboration.domain.model.timetracker.TimeExpression;
import com.github.jinjr.jinjrserver.collaboration.domain.model.timetracker.TimeTracking;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.TimeExpressionDTO;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.TimeTrackingDTO;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.WorklogCreatedDTO;

public class WorklogDTOAssembler {
    public WorklogCreatedDTO toDto(Worklog worklog) {

        TimeTracking timeTracking = worklog.getIssue().getTimeTracking();
        timeTracking.refresh();
        TimeExpression timeSpent = timeTracking.getOriginalEstimate().subtract(timeTracking.getRemainingEstimate());
        TimeTrackingDTO timeTrackingDTO = new TimeTrackingDTO(
                new TimeExpressionDTO(
                        timeTracking.getOriginalEstimate().getExpression(),
                        timeTracking.getOriginalEstimate().getSeconds()
                ),
                new TimeExpressionDTO(
                        timeTracking.getRemainingEstimate().getExpression(),
                        timeTracking.getRemainingEstimate().getSeconds()
                ),
                new TimeExpressionDTO(
                        timeSpent.getExpression(),
                        timeSpent.getSeconds()
                )
        );

        WorklogCreatedDTO dto = new WorklogCreatedDTO(
                worklog.getId(),
                new WorklogCreatedDTO.IssueDTO(
                        worklog.getIssue().getId(),
                        timeTrackingDTO
                ),
                new TimeExpressionDTO(
                        worklog.getTimeSpent().getExpression(),
                        worklog.getTimeSpent().getSeconds()
                ),
                worklog.getContent(),
                worklog.getStartedAt(),
                worklog.getCreatedAt(),
                worklog.getUpdatedAt()
        );

        return dto;
    }
}
