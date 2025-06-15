package Class;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Movie implements Comparable<Movie> {
    String title, director;
    int year;
    String type;

    public Movie(String title, String director, int year, String type) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("""
                             Title: %s
                             Director: %s
                             Year: %d
                             Type of Movies: %s
                             """,
                title, director, year, type);
    }

    @Override
    public int compareTo(Movie o) {
        return Integer.compare(this.year, o.getYear());
    }
}

class MovieCollection {
    List<Movie> movieCollection;
    int capacity;

    public MovieCollection(int capacity) {
        this.movieCollection = new ArrayList<>(capacity);
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return movieCollection.isEmpty();
    }

    public void addMovie(Movie movie) {
        if (movieCollection.size() < capacity) {
            movieCollection.add(movie);
        } else {
            System.out.println("Movie Collection is full.");
        }
    }

    public void removeMovie(String title) {
        boolean found = false;
        for (Movie movie : movieCollection) {
            if (movie.getTitle().equals(title)) {
                movieCollection.remove(movie);
                found = true;
                break; // Exit the loop after removing the movie
            }
        }
        if (!found) {
            System.out.println("Movie " + title + " not found.");
        }
    }

    public void findMovieCollectionByDirector(String director) {
        boolean found = false;
        for (Movie movie : movieCollection) {
            if (movie.getDirector().equals(director)) {
                System.out.println(movie.getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Director " + director + " does not produce any movies in this collection.");
        }
    }

    public void findMovieByTitle(String title) {
        boolean found = false;
        for (Movie movie : movieCollection) {
            if (movie.getTitle().equals(title)) {
                System.out.println(movie.toString());
                found = true;
                break; // Exit the loop after finding the movie
            }
        }
        if (!found) {
            System.out.println("Movie " + title + " not found.");
        }
    }

    public void sortMovieCollectionByReleaseYear() {
        Collections.sort(movieCollection);
    }

    public void findMovieCollectionByReleaseYearRange(int startYear, int endYear) {
        boolean found = false;
        for (Movie movie : movieCollection) {
            if (movie.getYear() >= startYear && movie.getYear() <= endYear) {
                System.out.println(movie.getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No movies found in the specified year range.");
        }
    }

    public void displayCollection() {
        if (movieCollection.isEmpty()) {
            System.out.println("The movie collection is empty.");
        } else {
            for (Movie movie : movieCollection) {
                System.out.println(movie);
            }
        }
    }
}

public class TestProgram {
    public static void main(String[] args) {
        MovieCollection movieCollection = new MovieCollection(5);

        Movie movie1 = new Movie("Inception", "Christopher Nolan", 2010, "Science Fiction");
        Movie movie2 = new Movie("The Shawshank Redemption", "Frank Darabont", 1994, "Drama");
        Movie movie3 = new Movie("Pulp Fiction", "Quentin Tarantino", 1994, "Crime");
        Movie movie4 = new Movie("The Dark Knight", "Christopher Nolan", 2008, "Action");
        Movie movie5 = new Movie("The Godfather", "Francis Ford Coppola", 1972, "Crime");

        movieCollection.addMovie(movie1);
        movieCollection.addMovie(movie2);
        movieCollection.addMovie(movie3);
        movieCollection.addMovie(movie4);
        movieCollection.addMovie(movie5);

        System.out.println("Searching for movie(s) by director:");
        movieCollection.findMovieCollectionByDirector("Christopher Nolan");

        System.out.println("\nSearching for a movie by title:");
        movieCollection.findMovieByTitle("Inception");

        System.out.println("\nMovies released between 1990 and 2010:");
        movieCollection.findMovieCollectionByReleaseYearRange(1990, 2010);

        System.out.println("\nSorted movie collection by release year:");
        movieCollection.sortMovieCollectionByReleaseYear();

        movieCollection.displayCollection();

        movieCollection.removeMovie(movie3.getTitle());
        System.out.println("\nUpdated Movie Collection:");
        movieCollection.displayCollection();
    }
}