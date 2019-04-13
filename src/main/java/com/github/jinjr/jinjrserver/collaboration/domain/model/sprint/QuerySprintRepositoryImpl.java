package com.github.jinjr.jinjrserver.collaboration.domain.model.sprint;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
@Transactional(readOnly = true)
public class QuerySprintRepositoryImpl implements QuerySprintRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public QuerySprintRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Sprint findAndCreateByName(String name) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Sprint> criteria = builder.createQuery(Sprint.class);
        Root<Sprint> sprintRoot = criteria.from(Sprint.class);


        criteria.where(
                builder.and(
                        builder.equal(sprintRoot.get("name"), name),
                        builder.equal(sprintRoot.get("todo").as(Boolean.class), true)
                )
        );

        Sprint sprint;
        try {
            sprint = entityManager.createQuery(criteria).getSingleResult();
        } catch (NoResultException e) {
            sprint = new Sprint();
            sprint.setName(name);
            sprint.setTodo(true);
            entityManager.persist(sprint);
        }

        return sprint;
    }
}
