package com.github.matheusgit11.NorthwindWithSpringBoot.Repository;

import com.github.matheusgit11.NorthwindWithSpringBoot.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
