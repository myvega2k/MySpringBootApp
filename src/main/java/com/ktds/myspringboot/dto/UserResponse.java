package com.ktds.myspringboot.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Long id;
    private String name;
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd:hh:mm:ss")
    private LocalDateTime createdAt;
}
