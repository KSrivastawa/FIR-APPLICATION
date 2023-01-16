package com.apps.fir.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
public class FirModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "[a-zA-Z]{3,12}", message = "Crime Detail should be alphabets only")
    private String crimeDetail;

    private LocalDateTime timeStamp = LocalDateTime.now();

    private String policeStation ;

    @JsonIgnore
    @ManyToOne
    private UserModel userModel;

}
