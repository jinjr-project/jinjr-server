package com.github.jinjr.jinjrserver.collaboration.application.impl;

import com.github.jinjr.jinjrserver.collaboration.application.ApplicationEvents;
import com.github.jinjr.jinjrserver.collaboration.domain.model.events.WorklogCreatedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class ApplicationEventsImpl implements ApplicationEvents {

    @TransactionalEventListener
    @Override
    public void generateWorklogAcitvity(WorklogCreatedEvent event) {
    }
}
