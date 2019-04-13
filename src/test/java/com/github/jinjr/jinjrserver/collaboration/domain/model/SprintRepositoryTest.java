package com.github.jinjr.jinjrserver.collaboration.domain.model;

import com.github.jinjr.jinjrserver.collaboration.domain.model.sprint.Sprint;
import com.github.jinjr.jinjrserver.collaboration.domain.model.sprint.SprintRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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

    @Test
    public void test2() {
        Sprint sprint = new Sprint();
        Issue issue = new Issue();
        sprint.assignIssue(issue);

        sprintRepository.save(sprint);

        Sprint sprint2 = sprintRepository.findById(sprint.getId()).get();
        List<Issue> issues = sprint2.getIssues();
    }
}
