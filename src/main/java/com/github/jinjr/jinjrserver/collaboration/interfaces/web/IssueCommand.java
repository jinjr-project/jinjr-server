package com.github.jinjr.jinjrserver.collaboration.interfaces.web;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class IssueCommand {

    @NotNull
    @NotEmpty
    private String summary;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
