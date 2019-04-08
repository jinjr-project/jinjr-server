package com.github.jinjr.jinjrserver.collaboration.domain.model.activity;

import com.github.jinjr.jinjrserver.collaboration.domain.model.Worklog;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("worklog")
public class WorklogActivity extends Activity {

    @OneToOne
    private Worklog worklog;

    public Worklog getWorklog() {
        return worklog;
    }

    public void setWorklog(Worklog worklog) {
        this.worklog = worklog;
    }
}