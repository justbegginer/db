package com.example.db.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private int cost;

    private int departmentId;

    @Column(name = "date_beg")
    private LocalDate dateBegging;

    private LocalDate dateEnd;

    private LocalDate dateEndReal;
}
