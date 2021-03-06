package com.github.jinjr.jinjrserver.collaboration.interfaces.internal;

import com.github.jinjr.jinjrserver.collaboration.application.IssueService;
import com.github.jinjr.jinjrserver.collaboration.application.impl.IssueServiceImpl;
import com.github.jinjr.jinjrserver.collaboration.domain.model.*;
import com.github.jinjr.jinjrserver.collaboration.domain.model.exceptions.IssueNotFound;
import com.github.jinjr.jinjrserver.collaboration.domain.model.sprint.SprintRepository;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.IssueServiceFacade;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.WorklogCreatedDTO;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.WorklogCreationDTO;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.internal.IssueServiceFacadeImpl;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.internal.assembler.IssueDTOAssembler;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@TestPropertySource(locations="classpath:application-test.properties")
public class IssueServiceFacadeImplTest {

    @Autowired
    private SprintRepository sprintRepository;

    @Autowired
    private IssueStatusRepository issueStatusRepository;

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private WorklogRepository worklogRepository;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    private IssueServiceFacade issueServiceFacade;

    @Test
    public void shouldBeCreateWorklog() throws IssueNotFound {
        Issue issue = new Issue();
        issue.setSummary("summary");
        issueRepository.save(issue);

        issueServiceFacade = createIssueServiceFacade();

        WorklogCreatedDTO dto = issueServiceFacade.addWorklog(new WorklogCreationDTO(
                issue.getId(),
                "1m",
                "10m",
                "worklog",
                new Date()
        ));

        Assert.assertEquals(660L, (long)dto.getIssue().getTimeTracking().getOriginalEstimate().getSeconds());
        Assert.assertEquals(600L, (long)dto.getIssue().getTimeTracking().getRemainingEstimate().getSeconds());
        Assert.assertEquals("worklog", dto.getContent());
        Assert.assertEquals("1m", dto.getTimeSpent().getExpression());

        dto = issueServiceFacade.addWorklog(new WorklogCreationDTO(
                issue.getId(),
                "1m",
                "0m",
                "worklog",
                new Date()
        ));

        Assert.assertEquals(660L, (long)dto.getIssue().getTimeTracking().getOriginalEstimate().getSeconds());
        Assert.assertEquals(540L, (long)dto.getIssue().getTimeTracking().getRemainingEstimate().getSeconds());

        dto = issueServiceFacade.addWorklog(new WorklogCreationDTO(
                issue.getId(),
                "540s",
                "0m",
                "worklog",
                new Date()
        ));

        Assert.assertEquals(660L, (long)dto.getIssue().getTimeTracking().getOriginalEstimate().getSeconds());
        Assert.assertEquals(0L, (long)dto.getIssue().getTimeTracking().getRemainingEstimate().getSeconds());

        dto = issueServiceFacade.addWorklog(new WorklogCreationDTO(
                issue.getId(),
                "40s",
                "0m",
                "worklog",
                new Date()
        ));

        Assert.assertEquals(700L, (long)dto.getIssue().getTimeTracking().getOriginalEstimate().getSeconds());
        Assert.assertEquals(0L, (long)dto.getIssue().getTimeTracking().getRemainingEstimate().getSeconds());
    }

    private IssueServiceFacade createIssueServiceFacade() {

        IssueDTOAssembler issueDTOAssembler = new IssueDTOAssembler(sprintRepository, issueRepository,
                issueStatusRepository);

        IssueService issueService = new IssueServiceImpl(issueRepository, worklogRepository, applicationEventPublisher);

        IssueServiceFacade issueServiceFacade = new IssueServiceFacadeImpl(issueRepository, issueStatusRepository,
                issueService, issueDTOAssembler, sprintRepository, worklogRepository);

        return issueServiceFacade;
    }
}
