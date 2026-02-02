package com.example.assignment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;

//http://localhost:8080/swagger-ui/index.html

@Entity
@Table(name = "employees")
public class Employee {
    public Employee(Long emp_id, String emp_name, String emp_mail, String emp_image_url, String emp_contact_no) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_mail = emp_mail;
        this.emp_image_url = emp_image_url;
        this.emp_contact_no = emp_contact_no;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emp_id;

    @NotBlank(message = "name id is mandatory")
    private String emp_name;

    @NotBlank(message = "mail id is mandatory")
    @Email(message = "Invalid email format")
    private String emp_mail;

    @NotBlank(message = "image url is mandatory")
    private String emp_image_url;

    @NotBlank(message = "contact info is mandatory")
    @Size(min = 10, max = 10)
    private String emp_contact_no;

    public Employee() {

    }


    public Long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Long emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_mail() {
        return emp_mail;
    }

    public void setEmp_mail(String emp_mail) {
        this.emp_mail = emp_mail;
    }

    public String getEmp_image_url() {
        return emp_image_url;
    }

    public void setEmp_image_url(String emp_image_url) {
        this.emp_image_url = emp_image_url;
    }

    public String getEmp_contact_no() {
        return emp_contact_no;
    }

    public void setEmp_contact_no(String emp_contact_no) {
        this.emp_contact_no = emp_contact_no;
    }
}
