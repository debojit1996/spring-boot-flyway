package com.debo.springbootflyway.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeWithoutEmailDto {
    private Long id;
    private String firstname;
    private String lastname;
}
