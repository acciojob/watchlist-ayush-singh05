package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository mr;

    public String addMovie(Movie m) {
        return mr.addMovie(m);
    }

    public String addDirector(Director dr) {
        return mr.addDirector(dr);
    }

    public String addMovieDirectorPair(String directorName,String movieName) {
        return mr.addMovieDirectorPair(directorName,movieName);
    }

    public Movie getMovieByName(String name) {
        return mr.getMovieByName(name);
    }

    public Director getDirectorByName(String name) {
        return mr.getDirectorByName(name);
    }

    public List<String> getMoviesByDirectorName(String name) {
        return mr.getMoviesByDirectorName(name);
    }

    public List<String> findAllMovies() {
        return mr.findAllMovies();
    }

    public String deleteDirectorByName(String directorName) {
        return mr.deleteDirectorByName(directorName);
    }

    public String deleteAllDirectors() {
        return mr.deleteAllDirectors();
    }
}
