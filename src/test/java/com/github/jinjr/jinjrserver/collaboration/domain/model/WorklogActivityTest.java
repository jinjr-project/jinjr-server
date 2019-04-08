package com.github.jinjr.jinjrserver.collaboration.domain.model;

import com.github.jinjr.jinjrserver.collaboration.domain.model.activity.ActivityRepository;
import com.github.jinjr.jinjrserver.collaboration.domain.model.activity.WorklogActivity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WorklogActivityTest {

    @Autowired
    private ActivityRepository repository;

    @Test
    public void testSave() {
        Worklog worklog = new Worklog();

        WorklogActivity activity = new WorklogActivity();
        activity.setSummary("test");
        activity.setWorklog(worklog);

        repository.save(activity);
    }
}
