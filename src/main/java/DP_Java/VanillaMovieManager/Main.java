package DP_Java.VanillaMovieManager;

public class Main {
    public static void main(String[] args) {
        MoviePersistor moviePersistor = new MoviePersistor();
        MovieDB movie = new MovieDB();
        movie.setId(1);
        movie.setTitle("Jaws");
        movie.setDirector("Steven spielberg");
        movie.setSynopsis("Story of a great white shark!");

        BasicMovieManager movieManager = new BasicMovieManager();
        movieManager.init();
        movieManager.persistMovie(movie);
        movieManager.findAll();
    }
}
