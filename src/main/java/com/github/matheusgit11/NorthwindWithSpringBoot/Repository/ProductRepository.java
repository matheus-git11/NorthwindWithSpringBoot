package com.github.matheusgit11.NorthwindWithSpringBoot.Repository;

import com.github.matheusgit11.NorthwindWithSpringBoot.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
