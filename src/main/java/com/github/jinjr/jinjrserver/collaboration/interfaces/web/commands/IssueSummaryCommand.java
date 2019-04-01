package com.github.jinjr.jinjrserver.collaboration.interfaces.web.commands;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class IssueSummaryCommand {

    @NotNull
    @NotEmpty
    private String summary;

    public String getSummary() {
        return summary;
    }
}
