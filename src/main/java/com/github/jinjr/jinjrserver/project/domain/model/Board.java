package com.github.jinjr.jinjrserver.project.domain.model;

import javax.persistence.*;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

//    @Column
//    private List<Sprint> sprints;
}
