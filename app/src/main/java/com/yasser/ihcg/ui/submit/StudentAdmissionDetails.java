package com.yasser.ihcg.ui.submit;

public class StudentAdmissionDetails {
    String token;
    String name;
    String type;
    String degree;
    String section;

    public StudentAdmissionDetails(String token, String name, String type, String degree, String section) {
        this.token = token;
        this.name = name;
        this.type = type;
        this.degree = degree;
        this.section = section;
    }

    public StudentAdmissionDetails() {
    }

    public StudentAdmissionDetails(String name, String type, String degree, String section) {
        this.token = "";
        this.name = name;
        this.type = type;
        this.degree = degree;
        this.section = section;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
