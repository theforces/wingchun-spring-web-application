package com.wingchun.wingchun.service.impl;

import com.wingchun.wingchun.model.dto.InstructorDto;
import com.wingchun.wingchun.model.entity.Instructor;
import com.wingchun.wingchun.repository.InstructorRepository;
import com.wingchun.wingchun.service.InstructorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public InstructorRepository getInstructorRepository() {
        return instructorRepository;
    }

    @Override
    public void addInstructor(InstructorDto instructorDto) {
        Instructor instructor = modelMapper.map(instructorDto, Instructor.class);
        instructorRepository.save(instructor);
    }


}
