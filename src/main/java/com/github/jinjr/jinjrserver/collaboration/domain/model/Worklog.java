package com.github.jinjr.jinjrserver.collaboration.domain.model;

import com.github.jinjr.jinjrserver.collaboration.domain.model.timetracker.TimeExpression;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Worklog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Issue issue;

    @Column
    private String content;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "seconds", column = @Column(name = "time_spent_seconds"))
    })
    private TimeExpression timeSpent;

    @Column
    private Date startedAt;

    @Column
    @LastModifiedDate
    private Date updatedAt;

    @Column
    @CreatedDate
    private Date createdAt;

    public Worklog(Long id, String content, TimeExpression timeSpent, Date startedAt) {
        this(content, timeSpent, startedAt);
        this.id = id;
    }

    public Worklog(String content, TimeExpression timeSpent, Date startedAt) {
        this.content = content;
        this.timeSpent = timeSpent;
        this.startedAt = startedAt;
    }

    public Worklog() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TimeExpression getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(TimeExpression timeSpent) {
        this.timeSpent = timeSpent;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
