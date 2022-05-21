package com.wingchun.wingchun.service.impl;

import com.wingchun.wingchun.model.dto.TrainingDto;
import com.wingchun.wingchun.model.entity.Training;
import com.wingchun.wingchun.repository.TrainingRepository;
import com.wingchun.wingchun.service.TrainingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TrainingRepository trainingRepository;

    @Override
    public TrainingRepository getTrainingRepository() {
        return trainingRepository;
    }

    @Override
    public void addTraining(TrainingDto trainingDto) {
        Training training = modelMapper.map(trainingDto, Training.class);
        trainingRepository.save(training);
    }
}
