package com.wingchun.wingchun.service.impl;

import com.wingchun.wingchun.model.dto.CourseDto;
import com.wingchun.wingchun.model.entity.Course;
import com.wingchun.wingchun.repository.CourseRepository;
import com.wingchun.wingchun.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CourseRepository getCourseRepository() {
        return courseRepository;
    }

    @Override
    public void addCourse(CourseDto courseDto) {
        Course course = modelMapper.map(courseDto, Course.class);
        courseRepository.save(course);
    }
}
