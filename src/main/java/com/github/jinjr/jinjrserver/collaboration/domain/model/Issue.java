package com.github.jinjr.jinjrserver.collaboration.domain.model;

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
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String summary;

    @ManyToOne(cascade = CascadeType.ALL)
    private Sprint sprint;

    @OneToOne(cascade = CascadeType.ALL)
    private IssueStatus status;

    @Embedded
    private TimeTracking timeTracking;

    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Worklog> worklogs;

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

    public void addWorklog(Worklog worklog) {
        if (null == worklogs) {
            worklogs = new ArrayList<>();
        }
        worklogs.add(worklog);
    }
}
