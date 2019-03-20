package com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto;

import java.util.List;

public class SprintDTO {
    private Long id;

    private String name;

    private List<IssueDTO> issues;

    public SprintDTO(Long id, String name, List<IssueDTO> issues) {
        this.id = id;
        this.name = name;
        this.issues = issues;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IssueDTO> getIssues() {
        return issues;
    }

    public void setIssues(List<IssueDTO> issues) {
        this.issues = issues;
    }
}
