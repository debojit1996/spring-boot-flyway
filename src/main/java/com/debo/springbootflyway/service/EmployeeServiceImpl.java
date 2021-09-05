package com.debo.springbootflyway.service;

import com.debo.springbootflyway.dto.EmployeeNameDto;
import com.debo.springbootflyway.dto.EmployeeWithoutEmailDto;
import com.debo.springbootflyway.model.Employee;
import com.debo.springbootflyway.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    @Override
    public Mono<Employee> createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Flux<EmployeeWithoutEmailDto> getAllEmployees() {
        return employeeRepository.findAll()
                .flatMap(employee -> {
                    var employeeWithoutEmailDto = new EmployeeWithoutEmailDto();
                    employeeWithoutEmailDto.setId(employee.getId());
                    employeeWithoutEmailDto.setFirstname(employee.getFirstname());
                    employeeWithoutEmailDto.setLastname(employee.getLastname());
                    return Mono.just(employeeWithoutEmailDto);
                });
    }

    @Override
    public Mono<EmployeeWithoutEmailDto> getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .flatMap(employee -> {
                    var employeeWithoutEmailDto = new EmployeeWithoutEmailDto();
                    employeeWithoutEmailDto.setId(employee.getId());
                    employeeWithoutEmailDto.setFirstname(employee.getFirstname());
                    employeeWithoutEmailDto.setLastname(employee.getLastname());
                    return Mono.just(employeeWithoutEmailDto);
                });
    }

    @Override
    public Mono<Void> deleteEmployeeById(Long id) {
        return employeeRepository.existsById(id)
                .flatMap(exists -> this.employeeRepository.deleteById(id));
    }

    @Override
    public Mono<Employee> updateEmployeeByIdWithPatch(Long id, EmployeeNameDto employeeNameDto) {
        var employee = new Employee();
        return employeeRepository.findById(id)
                .map(e -> {
                    employee.setId(e.getId());
                    employee.setFirstname(employeeNameDto.getFirstname());
                    employee.setLastname(e.getLastname());
                    employee.setEmail(e.getEmail());
                    return employee; })
                .flatMap(emp -> this.employeeRepository.save(employee));
    }


}
