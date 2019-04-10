package com.github.jinjr.jinjrserver.collaboration.application.impl;

import com.github.jinjr.jinjrserver.collaboration.application.IssueService;
import com.github.jinjr.jinjrserver.collaboration.domain.model.Issue;
import com.github.jinjr.jinjrserver.collaboration.domain.model.IssueRepository;
import com.github.jinjr.jinjrserver.collaboration.domain.model.Worklog;
import com.github.jinjr.jinjrserver.collaboration.domain.model.WorklogRepository;
import com.github.jinjr.jinjrserver.collaboration.domain.model.timetracker.TimeExpression;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
//@ContextConfiguration(classes = {IssueServiceImpl.class})
//@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class IssueServiceImplTest {

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private WorklogRepository worklogRepository;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Test
    public void testSpentTimeForIssue() {

        IssueService issueService = new IssueServiceImpl(issueRepository, worklogRepository, applicationEventPublisher);

        Issue issue = new Issue();
        issue.setSummary("issue");
        issueRepository.save(issue);

        Worklog worklog = new Worklog();
        worklog.setContent("worklog");
        worklog.setTimeSpent(new TimeExpression("1m"));

        Issue persistenced = issueService.spentTimeForIssue(worklog, issue, new TimeExpression("1m"));
    }
}
