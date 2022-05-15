package com.wingchun.wingchun.repository;

import com.wingchun.wingchun.model.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
