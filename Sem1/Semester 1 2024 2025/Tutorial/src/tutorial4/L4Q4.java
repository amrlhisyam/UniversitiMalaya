
package tutorial4;

import java.util.*;
import java.util.Scanner;
public class L4Q4 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        // Get the year and first day of the year from the user
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();
        System.out.print("Enter the first day of the year (0 for Sunday, 1 for Monday, ..., 6 for Saturday): ");
        int firstDayOfYear = scanner.nextInt();

        // Display the calendars for May and August
        System.out.println("\nCalendar for May " + year + ":");
        printMonthCalendar(5, year, firstDayOfYear);

        System.out.println("\nCalendar for August " + year + ":");
        printMonthCalendar(8, year, firstDayOfYear);
    }

    private static void printMonthCalendar(int month, int year, int firstDayOfYear) {
        int daysInMonth = getDaysInMonth(month, year);
        String monthName = (month == 5) ? "May" : "August";

        // Print the header
        System.out.println(monthName + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");

        // Calculate the first day of the month
        int firstDayOfMonth = getFirstDayOfMonth(month, year, firstDayOfYear);

        // Print leading spaces for the first day of the month
        for (int i = 0; i < firstDayOfMonth; i++) {
            System.out.print("   ");
        }

        // Print the days of the month
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%2d ", day);
            if ((firstDayOfMonth + day) % 7 == 0) {
                System.out.println(); // Move to the next line after Saturday
            }
        }
        System.out.println(); // Print a new line after the month is done
    }

    private static int getDaysInMonth(int month, int year) {
        if (month == 2) { // February
            return (isLeapYear(year)) ? 29 : 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) { // April, June, September, November
            return 30;
        } else { // January, March, May, July, August, October, December
            return 31;
        }
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private static int getFirstDayOfMonth(int month, int year, int firstDayOfYear) {
        int daysBeforeMonth = 0;

        // Calculate total days from previous months
        for (int m = 1; m < month; m++) {
            daysBeforeMonth += getDaysInMonth(m, year);
        }

        // Calculate the first day of the month
        return (firstDayOfYear + daysBeforeMonth) % 7;
    }
}


