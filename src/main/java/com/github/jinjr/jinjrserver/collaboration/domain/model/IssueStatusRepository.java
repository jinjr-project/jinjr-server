package com.github.jinjr.jinjrserver.collaboration.domain.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueStatusRepository extends CrudRepository<IssueStatus, Long> {
}
