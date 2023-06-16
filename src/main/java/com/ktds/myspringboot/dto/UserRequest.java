package com.ktds.myspringboot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {
    @NotEmpty(message = "Name은 필수 입력항목입니다.")
    private String name;
    @NotBlank(message = "Email은 필수 입력항목입니다.")
    private String email;
}
