package com.work.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.work.entities.Student;


public interface StudentRepository extends JpaRepository<Student,Long>{

}
