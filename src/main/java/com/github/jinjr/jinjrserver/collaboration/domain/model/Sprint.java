package com.github.jinjr.jinjrserver.collaboration.domain.model;

import javax.persistence.*;
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

    public void assignIssue(Issue issue) {
        issuesCount += 1;
        issue.setSprint(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
