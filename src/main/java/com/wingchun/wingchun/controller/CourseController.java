package com.wingchun.wingchun.controller;

import com.wingchun.wingchun.model.dto.CourseDto;
import com.wingchun.wingchun.model.entity.Course;
import com.wingchun.wingchun.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;
    private final ModelMapper modelMapper;

    public CourseController(CourseService courseService, ModelMapper modelMapper) {
        this.courseService = courseService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<?> getAllCourses() {
        List<Course> courseDtoList = courseService.getCourseRepository().findAll();
        List<CourseDto> courseDtos = courseDtoList.stream()
                .map(course -> modelMapper.map(course, CourseDto.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(courseDtos);
    }

    @GetMapping("{courseId}")
    public ResponseEntity<?> getCourseById(@PathVariable Long courseId) {

        if(!courseService.getCourseRepository().findById(courseId).isPresent()) {
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(modelMapper.map(courseService.getCourseRepository().findById(courseId), CourseDto.class), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<?> createCustomer(@Validated @RequestBody CourseDto courseDto) {
        courseService.addCourse(courseDto);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }

    @DeleteMapping("{courseId}")
    public ResponseEntity<?> DeleteCourseById(@PathVariable Long courseId) {

        if(!courseService.getCourseRepository().findById(courseId).isPresent()) {
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        }

        courseService.getCourseRepository().deleteById(courseId);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
