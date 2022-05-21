package com.wingchun.wingchun.controller;

import com.wingchun.wingchun.model.dto.InstructorDto;
import com.wingchun.wingchun.model.dto.TrainingDto;
import com.wingchun.wingchun.model.entity.Instructor;
import com.wingchun.wingchun.model.entity.Training;
import com.wingchun.wingchun.service.TrainingService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/trainings")
public class TrainingController {

    private final ModelMapper modelMapper;
    private final TrainingService trainingService;

    public TrainingController(ModelMapper modelMapper, TrainingService trainingService) {
        this.modelMapper = modelMapper;
        this.trainingService = trainingService;
    }

    @GetMapping
    public ResponseEntity<?> getAllTrainings() {
        List<Training> trainingList = trainingService.getTrainingRepository().findAll();
        List<TrainingDto> trainingDtos = trainingList.stream()
                .map(training -> modelMapper.map(training, TrainingDto.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(trainingDtos);
    }

    @GetMapping("{trainingId}")
    public ResponseEntity<?> getTrainingById(@PathVariable Long trainingId) {

        if (!trainingService.getTrainingRepository().findById(trainingId).isPresent()) {
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(modelMapper.map(trainingService.getTrainingRepository().findById(trainingId), TrainingDto.class), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<?> createTraining(@Validated @RequestBody TrainingDto trainingDto) {
        trainingService.addTraining(trainingDto);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }

    @DeleteMapping("{trainingId}")
    public ResponseEntity<?> deleteTrainingById(@PathVariable Long trainingId) {

        if (!trainingService.getTrainingRepository().findById(trainingId).isPresent()) {
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        }

        trainingService.getTrainingRepository().deleteById(trainingId);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
