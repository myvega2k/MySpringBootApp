package com.ktds.myspringboot.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd:hh:mm:ss")
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
