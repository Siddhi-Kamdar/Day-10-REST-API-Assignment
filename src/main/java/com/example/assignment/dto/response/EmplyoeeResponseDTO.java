package com.example.assignment.dto.response;

public class EmplyoeeResponseDTO {
    private Long emp_id;
    private String emp_name;
    private String emp_mail;
    private String emp_image_url;
    private String emp_contact_no;

    public EmplyoeeResponseDTO(Long emp_id, String emp_name, String emp_mail, String emp_image_url, String emp_contact_no) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_mail = emp_mail;
        this.emp_image_url = emp_image_url;
        this.emp_contact_no = emp_contact_no;
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
