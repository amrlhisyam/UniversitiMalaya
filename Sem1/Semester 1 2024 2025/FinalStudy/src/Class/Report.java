package Class;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Report {

    static int size = 0;

    public static void main(String[] args) {
        String inputFile = "oaiset.csv"; // Ensure the correct file extension
        OIARecord[] data = new OIARecord[50];
        System.out.println("Loading Dataset...");
        loadRecord(inputFile, data);
        System.out.println("The curated record is as follows: ");
        OIARecord[] cleanedData = cleanRecord(data);
        printRecord(cleanedData);
        System.out.println("The summary report is as follows:");
        reportData(cleanedData);
    }

    private static void loadRecord(String inputFile, OIARecord[] data) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            int index = 0;
            reader.readLine(); // Skip header line
            while ((line = reader.readLine()) != null && index < data.length) {
                String[] values = line.split(",");
                if (values.length == 13) {
                    data[index++] = new OIARecord(
                            values[0], values[1], values[2], values[3], values[4], values[5],
                            values[6], values[7], values[8], values[9], values[10], values[11], values[12]
                    );
                    size++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static OIARecord[] cleanRecord(OIARecord[] data) {
        String deletedString = "deleted";
        int counter = 0;

        // Count the number of records to be deleted
        for (int i = 0; i < size; i++) {
            if (data[i] != null && data[i].getStatus().equalsIgnoreCase(deletedString)) {
                counter++;
            }
        }

        // Create a new array to store non-deleted records
        OIARecord[] store = new OIARecord[size - counter];
        int index = 0;

        // Populate the new array with non-deleted records
        for (int i = 0; i < size; i++) {
            if (data[i] != null && !data[i].getStatus().equalsIgnoreCase(deletedString)) {
                store[index++] = data[i];
            }
        }
        return store;
    }

    public static void printRecord(OIARecord[] data) {
        for (OIARecord record : data) {
            if (record != null) {
                System.out.println(record.toString());
            }
        }
    }

    public static void reportData(OIARecord[] data) {
        // Maximum number of authors (assuming 8 authors per record)
        final int MAX_AUTHORS = 1000; // Adjust this based on expected unique authors
        String[] authors = new String[MAX_AUTHORS];
        int[] publicationCounts = new int[MAX_AUTHORS];
        int authorCount = 0;

        // Iterate through the records and count publications for each author
        for (OIARecord record : data) {
            if (record != null) {
                for (int i = 1; i <= 8; i++) { // Assuming authors are from author1 to author8
                    String author = null;
                    switch (i) {
                        case 1:
                            author = record.getAuthor1();
                            break;
                        case 2:
                            author = record.getAuthor2();
                            break;
                        case 3:
                            author = record.getAuthor3();
                            break;
                        case 4:
                            author = record.getAuthor4();
                            break;
                        case 5:
                            author = record.getAuthor5();
                            break;
                        case 6:
                            author = record.getAuthor6();
                            break;
                        case 7:
                            author = record.getAuthor7();
                            break;
                        case 8:
                            author = record.getAuthor8();
                            break;
                    }
                    if (author != null && !author.isEmpty()) {
                        // Check if the author is already in the authors array
                        int index = -1;
                        for (int j = 0; j < authorCount; j++) {
                            if (authors[j].equalsIgnoreCase(author)) {
                                index = j;
                                break;
                            }
                        }
                        // If the author is not found, add them
                        if (index == -1) {
                            authors[authorCount] = author;
                            publicationCounts[authorCount] = 1; // First publication
                            authorCount++;
                        } else {
                            // Increment the publication count for the existing author
                            publicationCounts[index]++;
                        }
                    }
                }
            }
        }

        // Print the summary report sorted by author name
        System.out.println("Summary Report of Publications:");

        // Print sorted authors and their publication counts
        for (int i = 0; i < authorCount; i++) {
            System.out.printf("%s: %d publications%n", authors[i], publicationCounts[i]);
        }
    }
}

class OIARecord {

    private String doi;
    private String subject;
    private String title;
    private String author1;
    private String author2;
    private String author3;
    private String author4;
    private String author5;
    private String author6;
    private String author7;
    private String author8;
    private String keyword;
    private String status;

    public OIARecord(String doi, String subject, String title, String author1, String author2, String author3, String author4, String author5, String author6, String author7, String author8, String keyword, String status) {
        this.doi = doi;
        this.subject = subject;
        this.title = title;
        this.author1 = author1;
        this.author2 = author2;
        this.author3 = author3;
        this.author4 = author4;
        this.author5 = author5;
        this.author6 = author6;
        this.author7 = author7;
        this.author8 = author8;
        this.keyword = keyword;
        this.status = status;
    }

    public String getDoi() {
        return doi;
    }

    public String getSubject() {
        return subject;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor1() {
        return author1;
    }

    public String getAuthor2() {
        return author2;
    }

    public String getAuthor3() {
        return author3;
    }

    public String getAuthor4() {
        return author4;
    }

    public String getAuthor5() {
        return author5;
    }

    public String getAuthor6() {
        return author6;
    }

    public String getAuthor7() {
        return author7;
    }

    public String getAuthor8() {
        return author8;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("%-40s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s",
                doi, title, subject, author1, author2, author3, author4, author5, author6, author7, author8, keyword, status);
    }
}
