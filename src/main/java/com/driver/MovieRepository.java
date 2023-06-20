package com.driver;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SimpleTimeZone;


@Repository
public class MovieRepository {
    private HashMap<String, Movie> movieDB = new HashMap<>();
    private HashMap<String, Director> directorDB = new HashMap<>();
    private HashMap<String, List<String>> pairDB = new HashMap<>();
    public String addMovie(Movie mv) {
        movieDB.put(mv.getName(),mv);
        return "Movie added Successfully!";
    }

    public String addDirector(Director dr) {
        directorDB.put(dr.getName(),dr);
        return "Director added Successfully!";
    }

    public String addMovieDirectorPair(String directorName,String movieName) {
        List<String>lt = pairDB.getOrDefault(directorName,new ArrayList<>());
        lt.add(movieName);
        pairDB.put(directorName,lt);
        System.out.println(lt);
        return "Pair added!";
    }

    public Movie getMovieByName(String name) {
        return movieDB.get(name);
    }

    public Director getDirectorByName(String name) {
        return directorDB.get(name);
    }

    public List<String> getMoviesByDirectorName(String name) {

        return new ArrayList<>(pairDB.get(name));
    }

    public List<String> findAllMovies() {
        List<String>list = new ArrayList<>();
        for(String str : movieDB.keySet()) {
            list.add(str);
        }
        return list;
    }

    public String deleteDirectorByName(String directorName) {
        pairDB.remove(directorName);
        return "Director delete Successfully!";
    }

    public String deleteAllDirectors() {
        for(String str : directorDB.keySet()) {
            directorDB.remove(str);
        }
        return "Delete Successfully!";
    }
}
