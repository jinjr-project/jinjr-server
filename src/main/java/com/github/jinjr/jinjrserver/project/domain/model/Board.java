package com.github.jinjr.jinjrserver.project.domain.model;

import com.github.jinjr.jinjrserver.collaboration.domain.model.Sprint;

import javax.persistence.*;
import java.util.List;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

//    @Column
//    private List<Sprint> sprints;
}
