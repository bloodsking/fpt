package com.optiontask;

import java.util.Scanner;

import static java.lang.System.exit;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

// public class Main {
//     public static void main(String[] args) {
//         // Simulasikan data orang dalam List
//         List<Person> people = new ArrayList<>();
//         people.add(new Person("John Doe", "1990-05-15"));
//         people.add(new Person("Jane Smith", "1985-12-10"));
//         people.add(new Person("Michael Johnson", "1995-02-20"));
//         people.add(new Person("Emily Brown", "1980-09-05"));

//         // Pengurutan berdasarkan tanggal lahir (ascending)
//         Collections.sort(people, Comparator.comparing(Person::getParsedDateOfBirth));

//         // Menampilkan data setelah diurutkan
//         System.out.println("Orang-orang berdasarkan tanggal lahir (dari yang termuda):");
//         for (Person person : people) {
//             System.out.println(person.getName() + " - " + person.getDateOfBirth());
//         }
//     }
// }

// class Person {
//     private String name;
//     private String dateOfBirth;

//     // Constructor
//     public Person(String name, String dateOfBirth) {
//         this.name = name;
//         this.dateOfBirth = dateOfBirth;
//     }

//     // Getter untuk nama
//     public String getName() {
//         return name;
//     }

//     // Getter untuk tanggal lahir (string)
//     public String getDateOfBirth() {
//         return dateOfBirth;
//     }

//     // Method untuk mengubah string tanggal lahir menjadi LocalDate
//     public LocalDate getParsedDateOfBirth() {
//         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//         return LocalDate.parse(dateOfBirth, formatter);
//     }
// }

public class Main {

    public static void printmenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    public static void main(String[] args) {

        String[] options = { "1- Break",
                "2- Choose File (.csv)",
                "3- Add new Employee",
                "4- Filter",
                "5- Export",
                "6- Saved File: " };
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option != 4) {
            printmenu(options);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        exit(0);
                        break;
                    case 2:
                        option2();
                        break;
                    case 3:
                        option3();
                        break;
                    case 4:
                        option4();
                    case 5:
                        option5();
                        break;
                    case 6:
                        option6();
                }
            } catch (Exception e) {
                System.out.println("Please enter an integer value between 1 and " +
                        options.length);
                scanner.next();
            }
        }
    }

    private static void option2() {
        Scanner filePath = new Scanner(System.in);
        System.out.print("Write your csv fila path: ");
        String csvFile = filePath.nextLine();
        dataUtils.readCSV(csvFile);

        System.out.println("Thanks for choosing option 2");
    }

    private static void option3() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Employee details:");
        System.out.print("Employee ID: ");
        String id = scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("DOB (dd/MM/yyyy): ");
        String dobString = scanner.nextLine();
        LocalDate dob = null;
        try {
            dob = LocalDate.parse(dobString, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in dd/MM/yyyy format.");
            return;
        }

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("Department: ");
        String department = scanner.nextLine();

        employee newEmployee = new employee(id, name, dob, address, department);
        dataUtils.addEmployee(newEmployee);
        System.out.println("Employee added successfully.");
    }

    private static void option4() {

        String[] optionsFilter = { "1- by Name",
                "2- by ID",
                "3- by doBirth",
                "4- by Year",
                "5- by Department",
                "6- Break " };

        int option = 1;
        while (option != 4) {
            printmenu(optionsFilter);
            try {
                Scanner scanner = new Scanner(System.in);
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        optionsFilter1();
                        break;
                    case 2:
                        optionsFilter2();
                        break;
                    case 3:
                        optionsFilter3();
                        break;
                    case 4:
                        optionsFilter4();
                    case 5:
                        optionsFilter5();
                        break;
                    case 6:
                        exit(0);

                }
            } catch (Exception e) {
                System.out.println("Please enter an integer value between 1 and " +
                        optionsFilter.length);
                Scanner scanner = new Scanner(System.in);
                scanner.next();
            }
        }

    }

    private static void option5() {
        dataUtils.compareYear();
    }

    private static void option6() {
        if (dataUtils.getEmployee().isEmpty() == false) {
            for (employee employee : dataUtils.getEmployee()) {
                System.out.printf("%-5s | %-20s | %-12s | %-30s | %-20s\n", employee.getID(),
                        employee.getName(),
                        employee.getDateBirth(), employee.getAddress(), employee.getDepartment());
            }

        } else {
            System.out.println("There is no last Data saved");
        }
    }

    private static void optionsFilter1() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'optionsFilter1'");
    }

    private static void optionsFilter2() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'optionsFilter1'");
    }

    private static void optionsFilter3() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'optionsFilter1'");
    }

    private static void optionsFilter4() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'optionsFilter1'");
    }

    private static void optionsFilter5() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'optionsFilter1'");
    }
}