package com.wingchun.wingchun.service;

import com.wingchun.wingchun.model.dto.TrainingDto;
import com.wingchun.wingchun.repository.TrainingRepository;

public interface TrainingService {
    TrainingRepository getTrainingRepository();

    void addTraining(TrainingDto trainingDto);
}
