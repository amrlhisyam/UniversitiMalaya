package Polymorphism;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Lab10q4 {
    public static void main(String[] args) {

        
        // Create a list to hold appointments
        List<Appointment> appointments = new ArrayList<>();
        
        // Example of creating appointments
        Appointment appointment1 = new Appointment(13, 6, 2025, 10);
        appointment1.setAppointment(10, 12); // Set appointment from 10 AM to 12 PM
        appointments.add(appointment1);
        appointment1.save(); // Save the appointment

        Appointment appointment2 = new Appointment(13, 6, 2025, 14);
        appointment2.setAppointment(14, 16); // Set appointment from 2 PM to 4 PM
        appointments.add(appointment2);
        appointment2.save(); // Save the appointment

        // Search for appointments within a specific time range
        LocalDateTime searchStart = LocalDateTime.of(2025, 6, 13, 9, 0); // 9 AM
        LocalDateTime searchEnd = LocalDateTime.of(2025, 6, 13, 15, 0); // 3 PM

        System.out.println("Searching for appointments between " + searchStart + " and " + searchEnd + ":");
        for (Appointment appointment : appointments) {
            if (appointment.search(searchStart, searchEnd)) {
                System.out.println("Found appointment: Start - " + appointment.getAppointmentStart() + ", End - " + appointment.getAppointmentEnd());
            }
        }
    }
}

interface Searchable {
    boolean search(LocalDateTime dateStartTime, LocalDateTime dateEndTime);
}

class Appointment implements Searchable {
    private LocalDateTime appointmentStart;
    private LocalDateTime appointmentEnd;

    public Appointment(int day, int month, int year, int hour) {
        this.appointmentStart = LocalDateTime.of(year, month, day, hour, 0);
        this.appointmentEnd = this.appointmentStart.plusHours(1); // Default duration of 1 hour
    }

    public void setAppointment(int startTime, int endTime) {
        this.appointmentStart = this.appointmentStart.withHour(startTime);
        this.appointmentEnd = this.appointmentStart.withHour(endTime);
    }

    public void save() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        try (PrintWriter writer = new PrintWriter(new FileOutputStream("appointment.txt"))) {
            writer.println("Appointment Start: " + appointmentStart.format(formatter));
            writer.println("Appointment End: " + appointmentEnd.format(formatter));
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        } catch (IOException e) {
            System.out.println("Error while output");
        }
    }

    @Override
    public boolean search(LocalDateTime dateStartTime, LocalDateTime dateEndTime) {
        return (appointmentStart.isEqual(dateStartTime) || appointmentStart.isAfter(dateStartTime)) &&
               (appointmentEnd.isEqual(dateEndTime) || appointmentEnd.isBefore(dateEndTime));
    }

    public LocalDateTime getAppointmentStart() {
        return appointmentStart;
    }

    public LocalDateTime getAppointmentEnd() {
        return appointmentEnd;
    }
}