package com.github.jinjr.jinjrserver.collaboration.domain.model.sprint;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepository extends CrudRepository<Sprint, Long>, QuerySprintRepository {
}
