package com.debo.springbootflyway.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("employee")
@Getter @Setter @ToString
public class Employee {

    @Id
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
}
