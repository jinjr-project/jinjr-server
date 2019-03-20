package com.github.jinjr.jinjrserver.collaboration.interfaces.facade.internal.assembler;

import com.github.jinjr.jinjrserver.collaboration.domain.model.Issue;
import com.github.jinjr.jinjrserver.collaboration.interfaces.facade.dto.IssueDTO;

public class IssueDTOAssembler {

    public IssueDTO toDto(Issue issue) {
        IssueDTO dto = new IssueDTO();
        dto.setId(issue.getId());
        dto.setSummary(issue.getSummary());
        dto.setCreatedAt(issue.getCreatedAt());
        dto.setUpdatedAt(issue.getUpdatedAt());

        return dto;
    }
}
