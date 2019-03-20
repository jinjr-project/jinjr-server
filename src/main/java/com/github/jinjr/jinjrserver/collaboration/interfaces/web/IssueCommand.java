package com.github.jinjr.jinjrserver.collaboration.interfaces.web;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class IssueCommand {

    @NotNull
    @NotEmpty
    private String summary;

    private Boolean isTodo = true;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Boolean getTodo() {
        return isTodo;
    }

    public void setTodo(Boolean todo) {
        isTodo = todo;
    }
}
