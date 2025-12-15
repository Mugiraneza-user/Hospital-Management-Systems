/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dpm;

/**
 *
 * @author educa
 */
import java.sql.*;

public class Tables {

    public static void main(String[] args) throws SQLException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "";
 // Create  table Receptionist
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Reception ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "FirstName VARCHAR(50), "
                    + "LastName VARCHAR(50), "
                    + "Email VARCHAR(50), "
                    + "Telephone VARCHAR(15))";
            Statement statement = connection.createStatement();
            statement.execute(createTableSQL);
            System.out.println("Table Created Successfully!");
            
             // Insert data into the table
            String insertSQL = "INSERT INTO Reception (FirstName, LastName, Email, Telephone) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            
            // Example data
            preparedStatement.setString(1, "Mugiraneza");
            preparedStatement.setString(2, "Isaac");
            preparedStatement.setString(3, "isaacmugiraneza41@gmail.com");
            preparedStatement.setString(4, "0790291916");

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Data Inserted Successfully!");
            }
             // Create  table User
             String createUsTableSQL = "CREATE TABLE IF NOT EXISTS User ("
                    + "useId INT PRIMARY KEY AUTO_INCREMENT, "
                    + "user VARCHAR(50) NOT NULL, "
                    + "email VARCHAR(50) NOT NULL, "
                    + "Password VARCHAR(50) NOT NULL, "
                    + "Role VARCHAR(50)  NOT NULL)";
                   
            statement.execute(createUsTableSQL);
            System.out.println("Authentication Table Created Successfully!");

             // Create table Patients
             String createPatTableSQL = "CREATE TABLE IF NOT EXISTS Patients ("
                    + "patId INT PRIMARY KEY AUTO_INCREMENT, "
                    + "FirstName VARCHAR(50) NOT NULL, "
                    + "LastName VARCHAR(50) NOT NULL, "
                    + "ID INT NOT NULL, "
                    + "PatientID INT NOT NULL, "
                    + "Diseases VARCHAR(50) NOT NULL, "
                    + "Telephone INT NOT NULL )";
                    
            statement.execute(createPatTableSQL);
            System.out.println("Patients Table Created Successfully!");
             // Create table Patients
            String createAppTableSQL = "CREATE TABLE IF NOT EXISTS Appointments ("
                    + "patId INT PRIMARY KEY AUTO_INCREMENT, "
                    + "FirstName VARCHAR(50) NOT NULL, "
                    + "LastName VARCHAR(50) NOT NULL, "
                    + "PatientID INT NOT NULL, "
                    + "Diseases VARCHAR(50) NOT NULL, "
                    + "Book VARCHAR(50)  NULL, "
                    + "Date DATE NOT NULL )";
                     
             statement.execute(createAppTableSQL);
            System.out.println("Appointments Table Created Successfully!");
                    
            
            
              // Create table Doctor
            String createDotTableSQL = "CREATE TABLE IF NOT EXISTS Doctor ("
                    + "patId INT PRIMARY KEY AUTO_INCREMENT, "
                    + "FirstName VARCHAR(50) NOT NULL, "
                    + "LastName VARCHAR(50) NOT NULL, "
                    + "Department VARCHAR(50) NOT NULL, "
                    + "Telephone INT NOT NULL, "
                    + "Specialist VARCHAR(50) NOT NULL )";
                     
             statement.execute(createDotTableSQL);
            System.out.println("Doctor Table Created Successfully!");
                    
            
             // Create table Doctor
            String createMesTableSQL = "CREATE TABLE IF NOT EXISTS Message ("
                    + "patId INT PRIMARY KEY AUTO_INCREMENT, "
                    + "FirstName VARCHAR(50) NOT NULL, "
                    + "LastName VARCHAR(50) NOT NULL, "
                    + "Diseases VARCHAR(50) NOT NULL, "
                    + "PatientID INT NOT NULL, "
                    + "Message VARCHAR(50) NOT NULL )";
                     
             statement.execute(createMesTableSQL);
            System.out.println("Message Table Created Successfully!");
                    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

