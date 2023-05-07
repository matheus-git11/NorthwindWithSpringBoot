package com.github.matheusgit11.NorthwindWithSpringBoot.Entity;

import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "territory")
public class territories {

    @Id
    @Column(name = "territory_id")
    private String territoryId;

    @Column(name = "territory_description")
    private String territoryDescription;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private region region;




}