package com.shivani.citra.controller;


import com.shivani.citra.model.Movie;
import com.shivani.citra.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class MovieController {
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @CrossOrigin
    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    public Movie saveMovie(@RequestBody Movie movie) {
        return movieService.saveMovie(movie);
    }

    @CrossOrigin
    @RequestMapping(value = "/movies/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie getSingleMovie(@PathVariable Long id) {
        return movieService.getSingleMovie(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public List<Movie> getMovie(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        if(pageSize == null || pageSize > 500)
            pageSize = 20;
        if(pageNumber == null || pageNumber > 500/pageSize)
            pageNumber = 1;
        return movieService.getAllMovies(pageNumber, pageSize);
    }
}
