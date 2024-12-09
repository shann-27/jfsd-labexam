package com.klef.jfsdexam;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClientDemo {
    public static void main(String[] args) {
        // Specify the department details to update
        int departmentId = 1; // Replace with the department ID to update
        String newName = "Updated Computer Science";
        String newLocation = "Updated Building A";

        // Use a try-with-resources block to handle database resources
        try (Connection connection = DBUtil.getConnection()) {
            // SQL query to update the department table
            String updateQuery = "UPDATE department SET name = ?, location = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

            // Set the positional parameters
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, newLocation);
            preparedStatement.setInt(3, departmentId);

            // Execute the update operation
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Successfully updated " + rowsAffected + " record(s) in the department table.");
            } else {
                System.out.println("No records updated. Please check the department ID.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
