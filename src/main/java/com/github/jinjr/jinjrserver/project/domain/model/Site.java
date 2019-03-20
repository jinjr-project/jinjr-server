package com.github.jinjr.jinjrserver.project.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

//    @Column
//    List<Project> projects;
}
