package com.training.course;

import java.util.Scanner;

public class Course implements ICourse {

    private String courseId;
    private String courseName;
    private double price;
    private int duration;

    // Dung chung Scanner voi cac lop khac
    public static final Scanner sc = new Scanner(System.in);

    // Constructor khong tham so
    public Course() {
    }

    // Constructor day du tham so
    public Course(String courseId, String courseName,
                  double price, int duration) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.price = price;
        this.duration = duration;
    }

    // Getter va Setter
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    // Nhap va kiem tra thong tin
    @Override
    public void inputDetails() {

        // Nhap ma khoa hoc
        while (true) {
            System.out.print("Enter course ID: ");
            String id = sc.nextLine().trim();

            if (!id.isEmpty()) {
                courseId = id;
                break;
            }

            System.out.println("Course ID cannot be empty!");
        }

        // Nhap ten khoa hoc
        while (true) {
            System.out.print("Enter course name: ");
            String name = sc.nextLine().trim();

            if (name.length() >= 3) {
                courseName = name;
                break;
            }

            System.out.println(
                "Course name must have at least 3 characters!"
            );
        }

        // Nhap hoc phi
        while (true) {
            System.out.print("Enter course price: ");
            String input = sc.nextLine().trim();

            try {
                double p = Double.parseDouble(input);

                if (Double.isFinite(p) && p > 0) {
                    price = p;
                    break;
                }

                System.out.println("Price must be greater than 0!");

            } catch (NumberFormatException e) {
                System.out.println("Invalid price! Please enter a number.");
            }
        }

        // Nhap thoi luong
        while (true) {
            System.out.print("Enter course duration (hours): ");
            String input = sc.nextLine().trim();

            try {
                int d = Integer.parseInt(input);

                if (d > 0) {
                    duration = d;
                    break;
                }

                System.out.println(
                    "Duration must be greater than 0!"
                );

            } catch (NumberFormatException e) {
                System.out.println(
                    "Invalid duration! Please enter an integer."
                );
            }
        }
    }

    // Tinh hoc phi sau giam gia
    @Override
    public double calculateFee() {

        if (price > 10000000) {
            return price * 0.85;
        } else if (price >= 5000000) {
            return price * 0.90;
        } else {
            return price;
        }
    }

    // Hien thi thong tin khoa hoc
    @Override
    public void displayDetails() {

        System.out.println("-----------------------------------");
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);

        System.out.printf("Original Price: %,.0f VND%n", price);

        System.out.println("Duration: " + duration + " hours");

        System.out.printf(
            "Final Fee: %,.0f VND%n",
            calculateFee()
        );

        System.out.println("-----------------------------------");
    }
}