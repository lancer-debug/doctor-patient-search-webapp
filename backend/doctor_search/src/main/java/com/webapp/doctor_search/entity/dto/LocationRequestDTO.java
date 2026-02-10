package com.webapp.doctor_search.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationRequestDTO {
    private String address;
    private String city;
    private String state;
    private String pinCode;
    private String country;
}
