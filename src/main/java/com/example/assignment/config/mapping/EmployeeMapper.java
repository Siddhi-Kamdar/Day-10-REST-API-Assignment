package com.example.assignment.config.mapping;

import com.example.assignment.dto.request.EmployeeDto;
import com.example.assignment.dto.response.EmplyoeeResponseDTO;
import com.example.assignment.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public static EmplyoeeResponseDTO toDto(Employee entity){
        return new EmplyoeeResponseDTO(
                entity.getEmp_id(),
                entity.getEmp_name(),
                entity.getEmp_mail(),
                entity.getEmp_image_url(),
                entity.getEmp_contact_no()
        );
    }
    public static Employee toEntity(EmployeeDto dto){
        return new Employee(
                dto.getEmp_id(),
                dto.getEmp_name(),
                dto.getEmp_mail(),
                dto.getEmp_image_url(),
                dto.getEmp_contact_no()
        );
    }
}
