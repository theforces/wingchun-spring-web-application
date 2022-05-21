package com.wingchun.wingchun.service.impl;

import com.wingchun.wingchun.model.dto.InstructorDto;
import com.wingchun.wingchun.model.dto.LearnerDto;
import com.wingchun.wingchun.model.entity.Instructor;
import com.wingchun.wingchun.model.entity.Learner;
import com.wingchun.wingchun.repository.LearnerRepository;
import com.wingchun.wingchun.service.LearnerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearnerServiceImpl implements LearnerService {

    @Autowired
    private LearnerRepository learnerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LearnerRepository getLearnerRepository() {
        return learnerRepository;
    }

    @Override
    public void addLearner(LearnerDto learnerDto) {
        Learner learner = modelMapper.map(learnerDto, Learner.class);
        learnerRepository.save(learner);
    }
}
