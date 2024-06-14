package com.optiontask;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class dateUtils {

    // public static void sortByDateOfBirth(List<employee> employeeData) {
    // Collections.sort(employeeData,
    // Comparator.comparing(dateUtils::getDateOfBirthAsLocalDate));
    // }

    // private static LocalDate getDateOfBirthAsLocalDate(employee employee) {
    // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    // return LocalDate.parse(employee.getDateBirth(), formatter);
    // }

    public static LocalDate parseDateOfBirth(String dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateOfBirth, formatter);
    }

    // public static void bubbleSortByDateOfBirth(List<employee> employees) {
    // int n = employees.size();
    // boolean swapped;

    // for (int i = 0; i < n - 1; i++) {
    // swapped = false;
    // for (int j = 0; j < n - i - 1; j++) {
    // LocalDate date1 = parseDateOfBirth(employees.get(j).getDateBirth());
    // LocalDate date2 = parseDateOfBirth(employees.get(j + 1).getDateBirth());

    // if (date1.isAfter(date2)) {
    // // Swap employees[j] and employees[j+1]
    // employee temp = employees.get(j);
    // employees.set(j, employees.get(j + 1));
    // employees.set(j + 1, temp);
    // swapped = true;
    // }
    // }
    // if (!swapped)
    // break;
    // }
    // }
}