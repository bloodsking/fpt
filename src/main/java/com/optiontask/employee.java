package com.optiontask;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class employee {
    private String id;
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private String department;

    employee(String id, String name, LocalDate dateOfbirth, String address, String department) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfbirth;
        this.address = address;
        this.department = department;
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public String getDepartment() {
        return department;
    }

    public String getFormattedDateOfBirth() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateOfBirth.format(formatter);
    }

    // public LocalDate getParsedDateOfBirth() {
    // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    // return LocalDate.parse(dateOfBirth, formatter);
    // }

}
