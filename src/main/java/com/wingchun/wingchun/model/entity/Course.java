package com.wingchun.wingchun.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "course_key_sequence_generator")
    @SequenceGenerator(name = "course_key_sequence_generator", sequenceName = "course_sequence", allocationSize = 1)
    private Long id;

    private String name;

    private Double duration;

    private Timestamp date;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "course_to_instructor",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "instructor_id"))
    private List<Instructor> instructorList;

    @OneToMany(mappedBy = "course")
    private List<Training> trainingList;

    @OneToMany(mappedBy = "course")
    private List<Learner> learnerList;

    @OneToOne(mappedBy = "course")
    private Location location;
}
