package com.wingchun.wingchun.model.entity;

import com.wingchun.wingchun.model.util.Information;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Instructor extends Information {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "instructor_key_sequence_generator")
    @SequenceGenerator(name = "instructor_key_sequence_generator", sequenceName = "instructor_sequence", allocationSize = 1)
    private Long id;

    @ManyToMany(mappedBy = "instructorList")
    private List<Course> courseList;
}
