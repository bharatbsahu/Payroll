package com.example.Payroll;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@EnableJpaRepositories("com.example.Payroll.*")
@Repository
interface EmployeeRepository extends JpaRepository<Employee, Long> {

}