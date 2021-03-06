package com.github.jinjr.jinjrserver.collaboration.interfaces.web.assembler;


import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.IssueUpdateDTO;
import com.github.jinjr.jinjrserver.collaboration.interfaces.web.commands.IssueUpdateCommand;

public class IssueCommandAssembler {

    public IssueUpdateDTO toDTO(IssueUpdateCommand command) {
        return new IssueUpdateDTO(command.getId(), command.getSummary(), command.getStatusId());
    }
}
