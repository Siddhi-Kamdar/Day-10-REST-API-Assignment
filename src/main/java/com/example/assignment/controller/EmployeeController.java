package com.example.assignment.controller;

import com.example.assignment.config.mapping.EmployeeMapper;
import com.example.assignment.dto.request.EmployeeDto;
import com.example.assignment.dto.response.EmplyoeeResponseDTO;
import com.example.assignment.entity.Employee;
import com.example.assignment.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public ResponseEntity<List<EmplyoeeResponseDTO>> getEmployee() {
        List<EmplyoeeResponseDTO> list = employeeRepository.findAll()
                .stream()
                .map(EmployeeMapper::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmplyoeeResponseDTO> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));

        return ResponseEntity.ok(EmployeeMapper.toDto(employee));
    }

    @PostMapping
    public ResponseEntity<EmplyoeeResponseDTO> addEmployee(
            @Valid @RequestBody EmployeeDto employeeDto) {

        Employee savedEmployee =
                employeeRepository.save(EmployeeMapper.toEntity(employeeDto));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(EmployeeMapper.toDto(savedEmployee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmplyoeeResponseDTO> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeDto employeeDto) {

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));

        existingEmployee.setEmp_name(employeeDto.getEmp_name());
        existingEmployee.setEmp_mail(employeeDto.getEmp_mail());
        existingEmployee.setEmp_image_url(employeeDto.getEmp_image_url());
        existingEmployee.setEmp_contact_no(employeeDto.getEmp_contact_no());

        Employee updatedEmployee = employeeRepository.save(existingEmployee);

        return ResponseEntity.ok(EmployeeMapper.toDto(updatedEmployee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not found with id " + id);
        }

        employeeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}