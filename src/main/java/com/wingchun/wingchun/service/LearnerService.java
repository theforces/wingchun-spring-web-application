package com.wingchun.wingchun.service;

import com.wingchun.wingchun.model.dto.LearnerDto;
import com.wingchun.wingchun.repository.LearnerRepository;

public interface LearnerService {
    LearnerRepository getLearnerRepository();

    void addLearner(LearnerDto learnerDto);
}
