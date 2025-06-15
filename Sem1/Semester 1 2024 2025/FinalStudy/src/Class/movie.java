/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Hisyam
 */
class movie implements Comparable<movie>{
    String title, director;
    int year;
    String type;

    public movie(String title, String director, int year, String type) {
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
    public String toString(){
        return String.format("""
                             Title: %s
                             Director: %s
                             Year: %d
                             Type of Movies: %s
                             """,
                title,director,year,type);
    }

    @Override
    public int compareTo(movie o) {
        int result =0;
        if(this.year > o.getYear()){
            result = 1;
        }
        else if (this.year< o.getYear()){
            result = -1;
        }
        else
            return 0;
        return result;
    }
    
    
}

class MovieCollection{
    List <movie> movieCollection;
    int numMovie;

    public MovieCollection(int numMovie) {
        this.movieCollection = new ArrayList<>(numMovie);
    }
    
    public boolean isEmpty(){
        return movieCollection.isEmpty();
    }
    
    public void addMovie(movie movie){
        if(movieCollection.indexOf(movie) < movieCollection.size()){
            movieCollection.add(movie);
        }
        else{
            System.out.println("Movie Collection is full.");
        }
    }
    
    public void removeMovie(String title){
        for(movie movie: movieCollection){
            if(movie.getTitle().equals(title)){
                movieCollection.remove(movie);
            }
            else{
                System.out.println("Movie "+title+" not found.");
            }
        }
    }
    
    public void findmovieCollectionByDirector(String director){
        for(movie movie: movieCollection){
            if(movie.getDirector().equals(director)){
                System.out.println(movie.getTitle());
            }
            else{
                System.out.println("Director " + director + " does not produce any movies in this collection.");
            }
        }
    }
    
    public void findMovieByTitle(String title){
        for(movie movie: movieCollection){
            if(movie.getDirector().equals(title)){
                System.out.println(movie.toString());
            }
            else{
                System.out.println("Movie "+title+" not found.");
            }
        }
    }
    
    public void sortMovieCollectionByReleaseYear(){
        Collections.sort(movieCollection);
    }
    
    public void findMovieCollectionByReleaseYearRange(int startYear, int endYear){
        for(movie movie:movieCollection){
            if(movie.getYear()>= startYear && movie.getYear()<= endYear){
                System.out.println(movie.getTitle());
            }
        }
    }
    
    public void displayCollection(){
        for(movie movie:movieCollection){
            System.out.println(movie.getTitle());
    }
}
    
public class TestProgram {  
   
    public static void main(String[] args) {
        
        MovieCollection movieCollection = new MovieCollection(5);  
   
        movie movie1 = new movie("Inception", "Christopher Nolan", 2010,  
                                 "Science Fiction");  
        movie movie2 = new movie("The Shawshank Redemption", "Frank "
                                + "Darabont", 1994, "Drama");  
        movie movie3 = new movie("Pulp Fiction", "Quentin Tarantino",  
                                  1994, "Crime");  
        movie movie4 = new movie("The Dark Knight", "Christopher Nolan",  
                                  2008, "Action");  
        movie movie5 = new movie("The Godfather", "Francis Ford Coppola",  
                                  1972, "Crime");  
   
        movieCollection.addMovie(movie1);  
        movieCollection.addMovie(movie2);  
        movieCollection.addMovie(movie3);  
        movieCollection.addMovie(movie4);  
        movieCollection.addMovie(movie5);  
   
        System.out.println("Searching for movie(s) by director:");  
     movieCollection.findmovieCollectionByDirector("Christopher Nolan");  
   
        System.out.println("\nSearching for a movie by title:");  
        movieCollection.findMovieByTitle("Inception");  
   
        System.out.println("\nMovies released between 1990 and 2010:");  
        movieCollection.findMovieCollectionByReleaseYearRange(1990,  
        2010);  
   
  
        System.out.println("\nSorted movieCollection by release year:");  
        movieCollection.sortMovieCollectionByReleaseYear();  

 
        movieCollection.displayCollection();  
   
        movieCollection.removeMovie(movie3.getTitle());    
        System.out.println("\nUpdated Movie Collection:");  
        movieCollection.displayCollection();  
        }  
    }
}  