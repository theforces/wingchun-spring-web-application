package com.wingchun.wingchun.model.entity;

import com.wingchun.wingchun.model.util.Information;
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
public class Learner extends Information {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "learner_key_sequence_generator")
    @SequenceGenerator(name = "learner_key_sequence_generator", sequenceName = "learner_sequence", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;
}
