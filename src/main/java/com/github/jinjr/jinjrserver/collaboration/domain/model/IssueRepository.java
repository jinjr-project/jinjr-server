package com.github.jinjr.jinjrserver.collaboration.domain.model;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IssueRepository extends CrudRepository<Issue, Long> {

//    @Query("SELECT i.summary, i.worklogs FROM Issue i JOIN Worklog w WHERE i.id = ?1")
    @Override
    Optional<Issue> findById(Long aLong);
}
