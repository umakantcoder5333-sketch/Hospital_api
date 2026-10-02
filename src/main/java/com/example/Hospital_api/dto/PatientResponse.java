package com.example.Hospital_api.dto;

public class PatientResponse {

    private Long id;
    private String name;
    private int age;
    private String gender;
    private String phone;
    private String disease;

    public PatientResponse() {
    }

    public PatientResponse(Long id, String name, int age, String gender,
                           String phone, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.disease = disease;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getDisease() {
        return disease;
    }
}