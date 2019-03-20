package com.github.jinjr.jinjrserver.collaboration.domain.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SprintRepositoryTest {

    @Autowired
    private SprintRepository sprintRepository;

    @Test
    public void testFind() {
        Sprint sprint = sprintRepository.findAndCreateByName("Default");

        Assert.assertEquals("Default", sprint.getName());
    }
}
