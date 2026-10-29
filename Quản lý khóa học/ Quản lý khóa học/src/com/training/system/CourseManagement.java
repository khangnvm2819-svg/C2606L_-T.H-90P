package com.training.system;

import com.training.course.Course;

import java.util.ArrayList;
import java.util.Comparator;

public class CourseManagement {

    private ArrayList<Course> courses = new ArrayList<>();

    // Question 3.1: Them khoa hoc
    public void addCourse() {

        System.out.println("\n===== ADD NEW COURSE =====");

        Course course = new Course();

        course.inputDetails();

        // Kiem tra trung ma khoa hoc
        for (Course c : courses) {

            if (c.getCourseId().equalsIgnoreCase(
                    course.getCourseId())) {

                System.out.println(
                    "Error: Course ID already exists!"
                );

                return;
            }
        }

        courses.add(course);

        System.out.println("Course added successfully!");
    }

    // Question 3.2: Hien thi danh sach
    public void showAllCourses() {

        System.out.println("\n===== ALL COURSES =====");

        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        for (Course course : courses) {
            course.displayDetails();
        }
    }

    // Question 3.3: Tim kiem theo ma
    public void searchCourseById() {

        System.out.println("\n===== SEARCH COURSE =====");

        System.out.print("Enter course ID to search: ");

        String id = Course.sc.nextLine().trim();

        for (Course course : courses) {

            if (course.getCourseId().equalsIgnoreCase(id)) {

                System.out.println("Course found:");

                course.displayDetails();

                return;
            }
        }

        System.out.println("Course not found.");
    }

    // Question 3.4: Sap xep theo hoc phi
    public void sortCoursesByFee() {

        System.out.println("\n===== SORT COURSES BY FEE =====");

        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        // Sap xep hoc phi goc tu thap den cao
        courses.sort(
            Comparator.comparingDouble(Course::getPrice)
        );

        System.out.println("Courses sorted by fee successfully!");

        showAllCourses();
    }

    // Question 3.5: Xoa khoa hoc
    public void removeCourse() {

        System.out.println("\n===== REMOVE COURSE =====");

        System.out.print("Enter course ID to remove: ");

        String id = Course.sc.nextLine().trim();

        for (int i = 0; i < courses.size(); i++) {

            if (courses.get(i).getCourseId()
                    .equalsIgnoreCase(id)) {

                courses.remove(i);

                System.out.println(
                    "Course removed successfully!"
                );

                return;
            }
        }

        System.out.println("Course not found. Cannot remove.");
    }
}