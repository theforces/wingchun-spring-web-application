package com.wingchun.wingchun.service;

import com.wingchun.wingchun.model.dto.CourseDto;
import com.wingchun.wingchun.repository.CourseRepository;

public interface CourseService {

    CourseRepository getCourseRepository();

    void addCourse(CourseDto courseDto);
}
