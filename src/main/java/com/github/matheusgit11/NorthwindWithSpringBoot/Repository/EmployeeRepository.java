package com.github.matheusgit11.NorthwindWithSpringBoot.Repository;

import com.github.matheusgit11.NorthwindWithSpringBoot.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
