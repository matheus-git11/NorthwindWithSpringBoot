package com.github.matheusgit11.NorthwindWithSpringBoot.Repository;

import com.github.matheusgit11.NorthwindWithSpringBoot.Entity.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipperRepository extends JpaRepository<Shipper,Integer> {
}
