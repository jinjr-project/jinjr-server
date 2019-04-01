package com.github.jinjr.jinjrserver.collaboration.domain.model;

import com.github.jinjr.jinjrserver.collaboration.domain.model.timetracker.TimeExpression;
import com.github.jinjr.jinjrserver.collaboration.domain.model.timetracker.TimeTracking;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@TestPropertySource(locations="classpath:application-test.properties")
public class IssueRepositoryTest {

    @Autowired
    private IssueRepository issueRepository;

    @Test
    public void shouldBeA() {
        Issue issue = new Issue();
        issue.setSummary("test");

        TimeTracking timeTracking = new TimeTracking();
        timeTracking.setOriginalEstimate(new TimeExpression("1m"));
        issue.setTimeTracking(timeTracking);
        issueRepository.save(issue);

        issue = issueRepository.findById(issue.getId()).get();

        Worklog worklog = new Worklog("worklog", new TimeExpression("1m"), new Date());
        issue.addWorklog(worklog);

        issueRepository.save(issue);

        issue = issueRepository.findById(issue.getId()).get();

//        timeTracking.spentTime(new TimeExpression("1m"));
        Assert.assertEquals(Long.valueOf(120L), timeTracking.getOriginalEstimate().getSeconds());
    }
}
