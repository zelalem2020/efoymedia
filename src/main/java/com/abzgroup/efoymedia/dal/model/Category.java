package com.abzgroup.efoymedia.dal.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cat_seq_gen")
    @SequenceGenerator(name = "cat_seq_gen", sequenceName = "cat_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

}
