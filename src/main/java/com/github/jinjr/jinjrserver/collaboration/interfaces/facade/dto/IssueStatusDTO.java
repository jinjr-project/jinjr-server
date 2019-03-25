package com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto;

public class IssueStatusDTO {

    private Long id;

    private String name;

    private String iconUrl;

    private String description;

    public IssueStatusDTO() {

    }

    public IssueStatusDTO(Long id, String name, String iconUrl, String description) {
        this.id = id;
        this.name = name;
        this.iconUrl = iconUrl;
        this.description = description;
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

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
