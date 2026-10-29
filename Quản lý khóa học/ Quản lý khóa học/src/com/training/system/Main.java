package com.training.system;

import com.training.course.Course;

public class Main {

    public static void main(String[] args) {

        CourseManagement management = new CourseManagement();

        int choice;

        do {

            System.out.println(
                "\n========== COURSE MANAGEMENT =========="
            );

            System.out.println("1. Add New Course");
            System.out.println("2. Show All Courses");
            System.out.println("3. Search Course By ID");
            System.out.println("4. Sort Courses By Fee");
            System.out.println("5. Remove Course");
            System.out.println("6. Exit");

            System.out.print("Your choice: ");

            String input = Course.sc.nextLine().trim();

            try {

                choice = Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                    "Invalid choice! Please enter a number from 1 to 6."
                );

                choice = 0;

                continue;
            }

            switch (choice) {

                case 1:
                    management.addCourse();
                    break;

                case 2:
                    management.showAllCourses();
                    break;

                case 3:
                    management.searchCourseById();
                    break;

                case 4:
                    management.sortCoursesByFee();
                    break;

                case 5:
                    management.removeCourse();
                    break;

                case 6:
                    System.out.println(
                        "Exiting Course Management System. Goodbye!"
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice! Please select from 1 to 6."
                    );
            }

        } while (choice != 6);
    }
}