package com.springBoot.repository;

import com.springBoot.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface employeeRespository extends JpaRepository<employee, Long> {

}