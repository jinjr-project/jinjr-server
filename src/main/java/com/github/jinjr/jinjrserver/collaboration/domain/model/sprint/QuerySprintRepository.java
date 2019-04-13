package com.github.jinjr.jinjrserver.collaboration.domain.model.sprint;

import com.github.jinjr.jinjrserver.collaboration.domain.model.sprint.Sprint;

public interface QuerySprintRepository {
    Sprint findAndCreateByName(String name);
}
