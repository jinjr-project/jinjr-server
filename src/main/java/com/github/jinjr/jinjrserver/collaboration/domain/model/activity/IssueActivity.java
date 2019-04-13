package com.github.jinjr.jinjrserver.collaboration.domain.model.activity;

import com.github.jinjr.jinjrserver.collaboration.domain.model.Issue;

import javax.persistence.*;

@Entity
@DiscriminatorValue("issue")
public class IssueActivity extends Activity {

    @ManyToOne
    private Issue issue;
}
