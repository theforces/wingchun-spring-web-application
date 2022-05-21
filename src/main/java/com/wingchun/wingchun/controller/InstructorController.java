package com.wingchun.wingchun.controller;

import com.wingchun.wingchun.model.dto.InstructorDto;
import com.wingchun.wingchun.model.entity.Instructor;
import com.wingchun.wingchun.service.InstructorService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    private final InstructorService instructorService;
    private final ModelMapper modelMapper;

    public InstructorController(InstructorService instructorService, ModelMapper modelMapper) {
        this.instructorService = instructorService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<?> getAllInstructors() {
        List<Instructor> instructorList = instructorService.getInstructorRepository().findAll();
        List<InstructorDto> instructorDtos = instructorList.stream()
                .map(instructor -> modelMapper.map(instructor, InstructorDto.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(instructorDtos);
    }

    @GetMapping("{instructorId}")
    public ResponseEntity<?> getInstructorById(@PathVariable Long instructorId) {

        if (!instructorService.getInstructorRepository().findById(instructorId).isPresent()) {
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(modelMapper.map(instructorService.getInstructorRepository().findById(instructorId), InstructorDto.class), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<?> createInstructor(@Validated @RequestBody InstructorDto instructorDto) {
        instructorService.addInstructor(instructorDto);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }

    @DeleteMapping("{instructorId}")
    public ResponseEntity<?> deleteInstructorById(@PathVariable Long instructorId) {

        if (!instructorService.getInstructorRepository().findById(instructorId).isPresent()) {
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        }

        instructorService.getInstructorRepository().deleteById(instructorId);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}

