package com.github.jinjr.jinjrserver.collaboration.domain.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sprint")
    private List<Issue> issues;

    @Column
    private Integer issuesCount = 0;

    public Sprint() {
        issues = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void assignIssue(Issue issue) {
        issuesCount += 1;
        issue.setSprint(this);
        issues.add(issue);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    public Integer getIssuesCount() {
        return issuesCount;
    }

    public void setIssuesCount(Integer issuesCount) {
        this.issuesCount = issuesCount;
    }
}
