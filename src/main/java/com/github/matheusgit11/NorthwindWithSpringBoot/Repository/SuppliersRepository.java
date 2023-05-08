package com.github.matheusgit11.NorthwindWithSpringBoot.Repository;

import com.github.matheusgit11.NorthwindWithSpringBoot.Entity.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuppliersRepository extends JpaRepository<Suppliers,Integer> {
}
