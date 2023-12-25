package com.peaksoft.gadgetariumj7.model.dto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AuthWithGoogleRequest {
    private Long id;
    private String name;
    private String userPic;
    private String email;
    private String gender;
    private String local;
    private LocalDate lastVisit;

}
