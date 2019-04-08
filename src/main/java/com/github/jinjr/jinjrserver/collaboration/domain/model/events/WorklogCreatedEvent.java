package com.github.jinjr.jinjrserver.collaboration.domain.model.events;

import com.github.jinjr.jinjrserver.collaboration.domain.model.Worklog;
import org.springframework.context.ApplicationEvent;

public class WorklogCreatedEvent extends ApplicationEvent {

    public WorklogCreatedEvent(Worklog worklog) {
        super(worklog);
    }

    public Worklog getWorklog() {
        return (Worklog)getSource();
    }
}
