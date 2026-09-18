package com.mycompany.pft;

import java.sql.*;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import static javafx.application.Application.launch;


public class PFT {
//    public static void main(String[] args) throws SQLException {
//       
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage stage) throws SQLException{
//        DatabaseInitialiser.initialiser();
//        Scene scene = new Scene(createContent());
//        stage.setScene(scene);
//        stage.show();
//    }
//    
//    private Region createContent(){
//        return new Label("Hello application!");
//    }
    
    public static void main(String[] args) {
        try {
            Connection conn = CreateLink.getConnection();

            // ---- Test CategoryDAO.retrieveAll() ----
            System.out.println("=== Categories ===");
            Category[] categories = CategoryDAO.retrieveAll(conn);
            for (Category c : categories) {
                System.out.println(c.getCategoryID() + " - " + c.getName());
            }

            if (categories.length == 0) {
                System.out.println("No categories found - stopping test here.");
                return;
            }

            // Use the first real category id from the array above
            int testCategoryId = categories[0].getCategoryID();

            // ---- Test TransactionDAO.insert() ----
            System.out.println("\n=== Inserting test transaction ===");
            TransactionDAO transactionDAO = new TransactionDAO();

            // id argument here is a placeholder - insert() ignores it,
            // since the database assigns the real id
            Transaction testTransaction = new Transaction(
                    0,
                    testCategoryId,
                    "expense",
                    25.50,
                    LocalDate.now(),
                    "Test transaction - delete me"
            );

            int newId = transactionDAO.insert(testTransaction, conn);
            System.out.println("Inserted with id: " + newId);

            // ---- Test TransactionDAO.retrieveAll() ----
            System.out.println("\n=== All transactions after insert ===");
            Transaction[] transactions = TransactionDAO.retrieveAll(conn);
            for (Transaction t : transactions) {
                System.out.println(t.getTransactionID() + " | category:" + t.getCategoryID()
                        + " | " + t.getType() + " | " + t.getAmount()
                        + " | " + t.getDate() + " | " + t.getDescription());
            }

            // ---- Test TransactionDAO.update() ----
            System.out.println("\n=== Updating test transaction ===");
            Transaction updatedTransaction = new Transaction(
                    newId,
                    testCategoryId,
                    "expense",
                    99.99,   // changed amount
                    LocalDate.now(),
                    "Test transaction - delete me"
            );
            transactionDAO.update(updatedTransaction, conn);

            System.out.println("=== All transactions after update ===");
            transactions = TransactionDAO.retrieveAll(conn);
            for (Transaction t : transactions) {
                System.out.println(t.getTransactionID() + " | " + t.getAmount());
            }

            // ---- Test TransactionDAO.delete() ----
            System.out.println("\n=== Deleting test transaction ===");
            transactionDAO.delete(newId, conn);

            System.out.println("=== All transactions after delete ===");
            transactions = TransactionDAO.retrieveAll(conn);
            for (Transaction t : transactions) {
                System.out.println(t.getTransactionID() + " | " + t.getDescription());
            }
            System.out.println("(should NOT include the test transaction anymore)");

        } catch (SQLException e) {
            System.err.println("Test failed: " + e);
        }
    }
    
}

