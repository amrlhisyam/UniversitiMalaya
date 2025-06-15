/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Polymorphism;

import java.util.Arrays;

/**
 *
 * @author Hisyam
 */
public class Movie implements Comparable <Movie> {
    
    String title;
    String director;
    int releaseDate;
    String rating;
    int rottenTomatoes;
    int imdb;

    public Movie (String title, String director, int releaseDate, String rating, int rottenTomatoes, int imb) {
        super();
        this.title = title;
        this.director = director;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.rottenTomatoes = rottenTomatoes;
        this.imdb = imb;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public int getRottenTomatoes() {
        return rottenTomatoes;
    }

    public int getImdb() {
        return imdb;
    }

    public void setRottenTomatoes(int rottenTomatoes) {
        this.rottenTomatoes = rottenTomatoes;
    }

    public void setImdb(int imdb) {
        this.imdb = imdb;
    }

    @Override
    public String toString() {
        return "Movies{" + "title=" + title + ", director=" + director + ", releaseDate=" + releaseDate + ", rating=" + rating + '}';
    }

    @Override
    public int compareTo(Movie o) {
        // Compare movies based on ITitle
        int result = 0;
        
        if(this.title.compareTo(o.getTitle()) <0){
            result = -1;
        }
        else if(this.title.compareTo(o.getTitle()) >0){
            result = 1;
        }
        else{
            return 0;
        }
        return result;
    }
    
    public int compareToImdb(Movie o) {
        // Compare movies based on IMDB ratings
        int result = 0;
        
        if(this.imdb<o.getImdb()){
            result = -1;
        }
        else if(this.imdb>o.getImdb()){
            result = 1;
        }
        else{
            return 0;
        }
        return result;
    }
}

class MoviePicker{
    public static void main(String[] args) {
        Movie movies[] = {
                new Movie("Inception", "Christopher Nolan", 2010, "PG-13", 148, 829),
                new Movie("The Godfather", "Francis Ford Coppola", 1972, "R", 175, 246),
                new Movie("The Dark Knight", "Christopher Nolan", 2008, "PG-13", 152, 1004),
                new Movie("Pulp Fiction", "Quentin Tarantino", 1994, "R", 154, 214),
                new Movie("The Shawshank Redemption", "Frank Darabont", 1994, "R", 142, 58), 
                new Movie("The Hurt Locker","Kathryn Bigelow",2008,"R",97,75)
            };
        
        Arrays.sort(movies);
        
        System.out.println("Movie choices: ");
        for(Movie x: movies){
            System.out.println(x);
        }
        
        
        Movie watch = movies[0];
        for(int i=1;i<movies.length;i++){
            if(movies[i].compareToImdb(watch)>0){
                watch = movies[i];
            }
        }
        
        
        System.out.println("");
        System.out.println("The best of these is " + watch.getTitle());
    }
}

