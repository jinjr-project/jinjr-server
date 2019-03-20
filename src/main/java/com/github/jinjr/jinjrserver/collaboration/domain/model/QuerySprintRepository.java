package com.github.jinjr.jinjrserver.collaboration.domain.model;

public interface QuerySprintRepository {
    Sprint findAndCreateByName(String name);
}
