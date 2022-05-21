package com.wingchun.wingchun.controller;

import com.wingchun.wingchun.model.dto.InstructorDto;
import com.wingchun.wingchun.model.dto.LearnerDto;
import com.wingchun.wingchun.model.entity.Learner;
import com.wingchun.wingchun.service.LearnerService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/learners")
public class LearnerController {

    private final LearnerService learnerService;
    private final ModelMapper modelMapper;

    public LearnerController(LearnerService learnerService, ModelMapper modelMapper) {
        this.learnerService = learnerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<?> getAllLearners() {
        List<Learner> learnerList = learnerService.getLearnerRepository().findAll();
        List<LearnerDto> learnerDtos = learnerList.stream()
                .map(learner -> modelMapper.map(learner, LearnerDto.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(learnerDtos);
    }

    @GetMapping("{learnerId}")
    public ResponseEntity<?> getLearnerById(@PathVariable Long learnerId) {

        if(!learnerService.getLearnerRepository().findById(learnerId).isPresent()) {
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(modelMapper.map(learnerService.getLearnerRepository().findById(learnerId), LearnerDto.class), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<?> createLearner(@Validated @RequestBody LearnerDto learnerDto) {
        learnerService.addLearner(learnerDto);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }

    @DeleteMapping("{learnerId}")
    public ResponseEntity<?> deleteLearnerById(@PathVariable Long learnerId) {

        if (!learnerService.getLearnerRepository().findById(learnerId).isPresent()) {
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        }

        learnerService.getLearnerRepository().deleteById(learnerId);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
