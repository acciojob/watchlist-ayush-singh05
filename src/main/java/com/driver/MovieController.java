package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {

    @Autowired
    MovieService ms;

    @PostMapping("/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie m) {
        return new ResponseEntity(ms.addMovie(m), HttpStatus.CREATED);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity addDirector(@RequestBody Director dr) {
        return new ResponseEntity(ms.addDirector(dr),HttpStatus.CREATED);
    }

    @PostMapping("/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestBody String directorName, @RequestBody String movieName) {
        return new ResponseEntity(ms.addMovieDirectorPair(directorName,movieName),HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String name){
        return new ResponseEntity(ms.getMovieByName(name),HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String name){
        return new ResponseEntity(ms.getDirectorByName(name),HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("name")String name) {
        return new ResponseEntity(ms.getMoviesByDirectorName(name),HttpStatus.FOUND);
    }


    @GetMapping("movies/get-all-movies")
    public ResponseEntity findAllMovies(){
        return new ResponseEntity(ms.findAllMovies(),HttpStatus.FOUND);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestBody String directorName) {
        return new ResponseEntity(ms.deleteDirectorByName(directorName),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        return new ResponseEntity(ms.deleteAllDirectors(),HttpStatus.ACCEPTED);
    }


}
