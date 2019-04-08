package com.github.jinjr.jinjrserver.collaboration.application;

import com.github.jinjr.jinjrserver.collaboration.domain.model.Worklog;
import com.github.jinjr.jinjrserver.collaboration.domain.model.events.WorklogCreatedEvent;

public interface ApplicationEvents {
    void generateWorklogAcitvity(WorklogCreatedEvent event);
}
