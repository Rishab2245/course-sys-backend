# Courses Management System - Backend

## Overview
This repository contains the backend component of the Courses Management System, a full-stack web application designed for managing academic courses and their delivery instances. Built with Spring Boot, it provides a robust REST API for all course and course instance management operations, ensuring data integrity and efficient data handling.

## Key Features
*   **Course Management**: Comprehensive CRUD (Create, Read, Update, Delete) operations for courses.
*   **Prerequisites Validation**: Ensures that all prerequisite courses exist before a new course is created or updated.
*   **Dependency Checking**: Prevents the deletion of courses that are currently set as prerequisites for other courses, maintaining data consistency.
*   **Course Instance Management**: Allows for the creation, retrieval, and deletion of specific course offerings by academic year and semester.
*   **RESTful API**: Provides a clean, well-structured, and stateless API for seamless communication with the frontend.

## Technology Stack
*   **Framework**: Spring Boot 3.2.0
*   **Language**: Java 17
*   **Database**: PostgreSQL (for production/Docker Compose), H2 (for local development/testing)
*   **ORM**: JPA/Hibernate
*   **Build Tool**: Maven
*   **Validation**: Jakarta Bean Validation

## Project Structure
