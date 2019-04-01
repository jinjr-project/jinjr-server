package com.github.jinjr.jinjrserver.collaboration.interfaces.web;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class WorklogCreationCommand {

    @NotNull
    private String spent;

    @NotEmpty
    private String remaining;

    private Date started;

    @NotEmpty
    private String content;

    public String getSpent() {
        return spent;
    }

    public void setSpent(String spent) {
        this.spent = spent;
    }

    public String getRemaining() {
        return remaining;
    }

    public void setRemaining(String remaining) {
        this.remaining = remaining;
    }

    public Date getStarted() {
        return started;
    }

    public void setStarted(Date started) {
        this.started = started;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
