package com.example.model.dto;

import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Serdeable
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {

    private String message;
    private LocalDateTime time;
}
