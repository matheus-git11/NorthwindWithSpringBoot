package com.github.matheusgit11.NorthwindWithSpringBoot.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "regions")
public class region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private int regionId;

    @Column(name = "region_description")
    private String regionDescription;

    @OneToMany(mappedBy = "region")
    private List<territories> territories;


}
