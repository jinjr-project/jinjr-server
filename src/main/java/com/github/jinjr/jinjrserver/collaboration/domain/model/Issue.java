package com.github.jinjr.jinjrserver.collaboration.domain.model;

import com.github.jinjr.jinjrserver.collaboration.domain.model.activity.Activity;
import com.github.jinjr.jinjrserver.collaboration.domain.model.activity.ActivityType;
import com.github.jinjr.jinjrserver.collaboration.domain.model.activity.IssueActivity;
import com.github.jinjr.jinjrserver.collaboration.domain.model.timetracker.TimeExpression;
import com.github.jinjr.jinjrserver.collaboration.domain.model.timetracker.TimeTracking;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NamedEntityGraph(name = "issue.findById", attributeNodes = {
        @NamedAttributeNode("worklogs"),
        @NamedAttributeNode("activities")
})
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String summary;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Sprint sprint;

    @OneToOne(cascade = CascadeType.PERSIST)
    private IssueStatus status;

    @Embedded
    private TimeTracking timeTracking;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "issue")
    private List<Worklog> worklogs;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "issue")
//    @JoinTable(name = "issue_activities",
//        joinColumns = {@JoinColumn(name = "activities_id")},
//        inverseJoinColumns = {@JoinColumn(name = "issue_id")})
    private List<IssueActivity> activities = new ArrayList<>();

    @CreatedDate
    @Column
    private Date createdAt;

    @LastModifiedDate
    @Column
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

    public IssueStatus getStatus() {
        return status;
    }

    public void setStatus(IssueStatus status) {
        this.status = status;
    }

    public TimeTracking getTimeTracking() {
        if (null == timeTracking) {
            timeTracking = new TimeTracking(new TimeExpression("0s"), new TimeExpression("0s"));
        }
        return timeTracking;
    }

    public void setTimeTracking(TimeTracking timeTracking) {
        this.timeTracking = timeTracking;
    }

    public List<Worklog> getWorklogs() {
        return worklogs;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void spentTime(Worklog worklog, TimeExpression remaining) {
        if (null == worklogs) {
            worklogs = new ArrayList<>();
        }
        TimeExpression beforeRemaining = getTimeTracking().getRemainingEstimate().clone();
        TimeExpression beforeTimeSpent = getTimeTracking().getTimeSpent().clone();

        getTimeTracking().spentTime(worklog.getTimeSpent(), remaining);

        IssueActivity summaryActivity = new IssueActivity();
        summaryActivity.setType(ActivityType.Worklog);
        summaryActivity.setChangedSummary(worklog.getContent());

        IssueActivity remainingActivity = new IssueActivity();
        remainingActivity.setType(ActivityType.RemainingEstimate);
        remainingActivity.setChangedSummary(getTimeTracking().getRemainingEstimate().getExpression().toUpperCase());

        IssueActivity spentActivity = new IssueActivity();
        spentActivity.setType(ActivityType.TimeSpent);
        spentActivity.setChangedSummary(getTimeTracking().getTimeSpent().getExpression().toUpperCase());

        if (worklogs.size() > 0) {
            Worklog lastWorklog = worklogs.get(worklogs.size() - 1);

            summaryActivity.setSummary(lastWorklog.getContent());
            remainingActivity.setSummary(beforeRemaining.getExpression().toUpperCase());
            spentActivity.setSummary(beforeTimeSpent.getExpression().toUpperCase());
        }

        activities.add(summaryActivity);
        activities.add(remainingActivity);
        activities.add(spentActivity);

        worklogs.add(worklog);
        worklog.setIssue(this);
    }
}
