package com.wingchun.wingchun.model.entity;

import com.wingchun.wingchun.model.util.Exercise;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "training_key_sequence_generator")
    @SequenceGenerator(name = "training_key_sequence_generator", sequenceName = "training_sequence", allocationSize = 1)
    private Long id;

    private String name;

    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;
}
