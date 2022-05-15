package com.wingchun.wingchun.repository;

import com.wingchun.wingchun.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
