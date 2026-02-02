package com.example.assignment.controller;

import com.example.assignment.config.mapping.EmployeeMapper;
import com.example.assignment.dto.request.EmployeeDto;
import com.example.assignment.dto.response.EmplyoeeResponseDTO;
import com.example.assignment.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/employees")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;
    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<EmplyoeeResponseDTO> getEmployee(){
        return employeeRepository.findAll().stream().map(EmployeeMapper::toDto).collect(Collectors.toList());
    }

    @PostMapping
    public  EmplyoeeResponseDTO addEmployee(@RequestBody EmployeeDto employeeDto){
        return EmployeeMapper.toDto(employeeRepository.save(EmployeeMapper.toEntity(employeeDto)));
    }

}
