/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ledger.system;

import java.sql.Connection;
import java.util.Calendar;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author nitrom
 */
/**
 * @param args the command line arguments
 */
public class Savings {

    public static double percentage;
    public String user_id;
    public String name;
    public static double accumulated_savings;

    public void run(String user_id, String name) {
        this.user_id = user_id; //test user
        this.name = name; // test name

        try {
            // Test connection
            ConnMYSQL conn = new ConnMYSQL();
            Connection connection = conn.c; // Use the connection from ConnMYSQL
            if (connection != null) {
                System.out.println("Database connection successful!"); // tell console connection was successful
                String account_query = "SELECT user_id FROM Savings WHERE user_id = ?"; // query to check whether the id is part of the savings table
                PreparedStatement savingsStmt = connection.prepareStatement(account_query); //prepare the messenger
                savingsStmt.setString(1, user_id); // change the ? with userId
                ResultSet account_exist_result = savingsStmt.executeQuery(); //execute the query and add the result

                if (!account_exist_result.next()) { //move cursor to first row and if it doesn't exist, make a SavingsNotExist() frame.
                    //user does not exist
                    new SavingsNotExist(user_id, name);

                } else {
                    //user exists

                    String percentage_query = "SELECT user_id,percentage,accumulated_savings FROM Savings WHERE user_id = ?";
                    PreparedStatement prepared_percentage_statement = connection.prepareStatement(percentage_query);
                    prepared_percentage_statement.setString(1, user_id);
                    ResultSet percentage_result = prepared_percentage_statement.executeQuery();
                    percentage_result.next();
                    percentage = percentage_result.getDouble("percentage");
                    accumulated_savings = percentage_result.getDouble("accumulated_savings");

                    if (percentage == 0) {
                        new SavingsNotExist(user_id, name);
                    } else {
                        new SavingsExist(user_id, name);
                    }
                    // close resources

                    percentage_result.close();
                    prepared_percentage_statement.close();
                }

                // close resources to avoid unnecessary memory usage   
                account_exist_result.close();
                savingsStmt.close();
                connection.close();

            }
        } catch (Exception e) {
            System.out.println("Database connection failed."); // tell console connection was not successful
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Couldn't establish the connection to the database!", "Database Connection Failed!", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void savings_update(String user_id) {
        System.out.println("Updating savings...");
        int last_updated_year = 0;
        int last_updated_month = 0;
        int last_updated_day = 0;
        double debit = 0;
        double percentage = 0;
        double accumulated_savings = 0;
        double amount = 0;
        Calendar calendar = Calendar.getInstance();

        try {
            // Test connection  
            ConnMYSQL conn = new ConnMYSQL();
            Connection connection = conn.c; // Use the connection from ConnMYSQL
            if (connection != null) {
                System.out.println("Database connection successful!"); // tell console connection was successful
                String account_query = "SELECT user_id FROM Savings WHERE user_id = ?"; // query to check whether the id is part of the savings table
                PreparedStatement updateCheck = connection.prepareStatement(account_query); //prepare the messenger
                updateCheck.setString(1, user_id); // change the ? with userId
                ResultSet possible_update = updateCheck.executeQuery(); //execute the query and add the result

                if (!possible_update.next()) { //move cursor to first row and if it doesn't exist, exit the method
                    System.out.println("No savings account at all!");
                    //user does not exist
                    return;
                } else {
                    // user has a savings account 

                    String savings_query = "SELECT percentage, last_updated_year, last_updated_month, last_updated_day, accumulated_savings FROM Savings WHERE user_id = ?";
                    PreparedStatement savings_stmt = connection.prepareStatement(savings_query);
                    savings_stmt.setString(1, user_id); // Set the user_id for the query
                    ResultSet savings_result = savings_stmt.executeQuery();

                    if (savings_result.next()) {
                        percentage = savings_result.getDouble("percentage");
                        last_updated_year = savings_result.getInt("last_updated_year");
                        last_updated_month = savings_result.getInt("last_updated_month");
                        last_updated_day = savings_result.getInt("last_updated_day");
                        accumulated_savings = savings_result.getDouble("accumulated_savings");
                    }

                    // Fetch the balance from the bank table
                    String bank_query = "SELECT balance FROM bank WHERE userid = ? ORDER BY datedata DESC, balance DESC LIMIT 1";
                    PreparedStatement bank_stmt = connection.prepareStatement(bank_query);
                    bank_stmt.setString(1, user_id); // Set the user_id for the query
                    ResultSet bank_result = bank_stmt.executeQuery();

                    if (bank_result.next()) {
                        debit = bank_result.getDouble("balance");
                    } else {
                        System.out.println("No balance.");
                        return;
                    }

                    if (percentage == 0) {
                        System.out.println("Savings percentage is not set. Removing any existing accumulated_savings.");
                        //in case the savings account was just closed, remove any accumulated savings and add back to balance
                        debit += accumulated_savings;
                        amount += accumulated_savings;
                        accumulated_savings = 0;

                        last_updated_month = 0;
                        last_updated_year = 0;
                        last_updated_day = 0;
                        if ( amount == 0){
                            return;}
                        update_query_savings_addition(user_id, last_updated_month, last_updated_year, last_updated_day, debit, accumulated_savings, amount);
                        return;

                    }
                    savings_stmt.close();
                    bank_stmt.close();

                    //set the current year,month and date to simplify code
                    int current_year = calendar.get(Calendar.YEAR);
                    int current_month = calendar.get(Calendar.MONTH);
                    int current_day = calendar.get(Calendar.DAY_OF_MONTH);

                    int year_difference = 0, month_difference = 0;

                    //if the user hasn't logged in for more than a year(s), the month_difference will be added accordingly (made sure to check for null year or null month (first time users))
                    if (last_updated_year < current_year && last_updated_year != 0 && last_updated_month != 0) {
                        year_difference = current_year - last_updated_year;
                        month_difference += (year_difference * 12);
                        month_difference += current_month - last_updated_month;
                    }

                    // if there's a difference in the month
                    if (month_difference == 1) {
                        // check to see if it was updated on the last day of that month, create an instance of last month's calendar

                        //calendar of previous month
                        Calendar previousMonthCalendar = Calendar.getInstance();
                        previousMonthCalendar.setTime(calendar.getTime()); // Copy the original calendar's date
                        previousMonthCalendar.add(Calendar.MONTH, -1); // Move to the previous month

                        //maximum day of previous month
                        int lastDayOfPreviousMonth = previousMonthCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);

                        if (last_updated_day == lastDayOfPreviousMonth) {
                            System.out.println("Was already updated on the end of last month or it hasn't been a month yet!");
                            return;
                        } else {
                            accumulated_savings += percentage / 100 * debit;
                            amount -= percentage / 100 * debit;
                            debit -= percentage / 100 * debit;
                            last_updated_month = calendar.get(Calendar.MONTH);
                            last_updated_year = calendar.get(Calendar.YEAR);
                            last_updated_day = calendar.get(Calendar.DAY_OF_MONTH);
                        }

                        //do nothing since it already updated at the last day of last month
                    } else if (month_difference > 0) {
                        for (int a = 0; a < month_difference; a++) {
                            accumulated_savings += percentage / 100 * debit;
                            amount -= percentage / 100 * debit;
                            debit -= percentage / 100 * debit;
                        }
                        last_updated_month = calendar.get(Calendar.MONTH);
                        last_updated_year = calendar.get(Calendar.YEAR);
                        last_updated_day = calendar.get(Calendar.DAY_OF_MONTH);
                    } else if (month_difference == 0 && (current_day == calendar.getActualMaximum(Calendar.DAY_OF_MONTH))) { // if it is the last day of the month
                        accumulated_savings += percentage / 100 * debit;
                        amount -= percentage / 100 * debit;
                        debit -= percentage / 100 * debit;
                        last_updated_month = calendar.get(Calendar.MONTH);
                        last_updated_year = calendar.get(Calendar.YEAR);
                        last_updated_day = calendar.get(Calendar.DAY_OF_MONTH);

                    } else {
                        System.out.println("Not the end of the month or greater than a month since last login.");
                        return; // go back to the main class and don't execute the following queries
                    }
                    System.out.println("Updated savings!");
                    update_query_savings_addition(user_id, last_updated_month, last_updated_year, last_updated_day, debit, accumulated_savings, amount);
                }
            }

        } catch (Exception e) {
            System.out.println("Database connection failed."); // tell console connection was not successful
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Couldn't establish the connection to the database!", "Database Connection Failed!", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void update_query_savings_addition(String user_id, int last_updated_month, int last_updated_year, int last_updated_day, double debit, double accumulated_savings, double amount) {
        try {
            // Test connection
            ConnMYSQL conn = new ConnMYSQL();
            Connection connection = conn.c; // Use the connection from ConnMYSQL
            if (connection != null) {
                System.out.println("Database connection successful!");
                //update savings table
                String update_query_savings = "INSERT INTO Savings (accumulated_savings, last_updated_month, last_updated_year,user_id, last_updated_day)\n"
                        + "VALUES (?, ?, ?, ?, ?)\n"
                        + "ON DUPLICATE KEY UPDATE "
                        + "accumulated_savings = VALUES(accumulated_savings), "
                        + "last_updated_month = VALUES(last_updated_month), "
                        + "last_updated_year = VALUES(last_updated_year), "
                        + "last_updated_day = VALUES(last_updated_day)";

                PreparedStatement savings_update = connection.prepareStatement(update_query_savings);
                savings_update.setDouble(1, accumulated_savings);
                savings_update.setInt(2, last_updated_month);
                savings_update.setInt(3, last_updated_year);
                savings_update.setString(4, user_id);
                savings_update.setInt(5, last_updated_day);
                savings_update.executeUpdate();

                //update balance in bank
                String update_query_balance = "INSERT INTO bank (userid, datedata, type, description, amount, balance) "
                        + "VALUES (?, NOW(), 'Savings', ?, ?, ?)";

                PreparedStatement balance_update = connection.prepareStatement(update_query_balance);
                balance_update.setString(1, user_id); // userid
                if (accumulated_savings == 0){
                balance_update.setString(2, "Added"); // added to balance
                
                }
                else{
                balance_update.setString(2, "Subtracted"); // removed from balance
                
                }
                balance_update.setDouble(3, amount); 
                balance_update.setDouble(4, debit); // Current balance
                balance_update.executeUpdate();

            }
        } catch (Exception e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        }
    }

}
