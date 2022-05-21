package com.wingchun.wingchun.service;

import com.wingchun.wingchun.model.dto.InstructorDto;
import com.wingchun.wingchun.repository.InstructorRepository;

public interface InstructorService {

    InstructorRepository getInstructorRepository();

    void addInstructor(InstructorDto instructorDto);
}
