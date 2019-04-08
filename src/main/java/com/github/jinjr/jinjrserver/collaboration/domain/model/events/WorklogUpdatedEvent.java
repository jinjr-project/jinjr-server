package com.github.jinjr.jinjrserver.collaboration.domain.model.events;

import com.github.jinjr.jinjrserver.collaboration.domain.model.Worklog;
import org.springframework.context.ApplicationEvent;

public class WorklogUpdatedEvent extends ApplicationEvent {

    public WorklogUpdatedEvent(Worklog worklog) {
        super(worklog);
    }

    public Worklog getWorklog() {
        return (Worklog)getSource();
    }
}
