package com.wingchun.wingchun.model.entity;

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
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "location_key_sequence_generator")
    @SequenceGenerator(name = "location_key_sequence_generator", sequenceName = "location_sequence", allocationSize = 1)
    private Long id;

    private String country;

    private String city;

    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
