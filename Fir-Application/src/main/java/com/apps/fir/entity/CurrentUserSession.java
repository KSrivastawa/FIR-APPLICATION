package com.apps.fir.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUserSession {

    @Id
    @Column(unique = true)
    private Long id;
    private String uuid;
    private LocalDateTime localDateTime;

}
