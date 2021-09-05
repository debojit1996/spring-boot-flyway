package com.debo.springbootflyway.service;

import com.debo.springbootflyway.dto.EmployeeNameDto;
import com.debo.springbootflyway.model.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    Mono<Employee> createEmployee(Employee employee);

    Flux<Employee> getAllEmployees();

    Mono<Employee> getEmployeeById(Long id);

    Mono<Void> deleteEmployeeById(Long id);

    Mono<Employee> updateEmployeeByIdWithPatch(Long id, EmployeeNameDto employee);
}
