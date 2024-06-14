package com.optiontask;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class dataUtils {

    private static List<employee> employeeData = new ArrayList<>();

    public static void readCSV(String csvFile) {
        // try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
        // employeeData.clear(); // Clear existing data
        // String[] line;
        // while ((line = reader.readNext()) != null) {
        // employee employee = new employee(line[0], line[1], line[2], line[3],
        // line[4]);
        // employeeData.add(employee);
        // }
        // printEmployeeData();
        // } catch (IOException | CsvValidationException e) {
        // e.printStackTrace();
        // }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            employeeData.clear(); // Clear existing data
            String[] line;
            while ((line = reader.readNext()) != null) {
                try {
                    LocalDate dateOfBirth = LocalDate.parse(line[2], formatter);
                    employee employee = new employee(line[0], line[1], dateOfBirth, line[3], line[4]);
                    employeeData.add(employee);
                } catch (DateTimeParseException e) {
                    System.out.println("Error parsing date for employee: " + line[1]);
                    e.printStackTrace();
                }
            }
            printEmployeeData();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    public static List<employee> getEmployee() {
        return employeeData;
    }

    public static void printEmployeeData() {

        System.out.printf("%-5s | %-20s | %-12s | %-30s | %-20s\n", "ID", "Name", "DateOfBirth", "Address",
                "Department");
        System.out.println(
                "--------------------------------------------------------------------------------------------");
        for (employee employee : employeeData) {
            try {
                System.out.printf("%-5s | %-20s | %-12s | %-30s | %-20s\n", employee.getID(), employee.getName(),
                        employee.getFormattedDateOfBirth(), employee.getAddress(), employee.getDepartment());
            } catch (Exception e) {

            }

        }
    }

    public static void compareYear() {
        employeeData.sort((employee p1, employee p2) -> p1.getDateBirth().compareTo(p2.getDateBirth()));
        for (employee person : employeeData) {
            System.out.printf("%-5s | %-20s | %-12s | %-30s | %-20s\n", person.getID(), person.getName(),
                    person.getFormattedDateOfBirth(), person.getAddress(), person.getDepartment());
        }
        saveToCSV("employee.csv");
    }

    public static void addEmployee(employee employee) {
        employeeData.add(employee);

    }

    private static void saveToCSV(String csvFile) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {
            for (employee employee : employeeData) {
                writer.writeNext(
                        new String[] { employee.getID(), employee.getName(), employee.getFormattedDateOfBirth(),
                                employee.getAddress(), employee.getDepartment() });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
