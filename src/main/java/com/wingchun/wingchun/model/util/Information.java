package com.wingchun.wingchun.model.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Information {

    private String lastName;
    private String firstName;
    private String phoneNumber;
}
