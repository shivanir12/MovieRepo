package com.shivani.citra.service;

import com.shivani.citra.model.Movie;
import com.shivani.citra.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie saveMovie(Movie movieToSave) {
        return movieRepository.save(movieToSave);
    }

    public Movie getSingleMovie(Long id) {
        return movieRepository.findOne(id);
    }

    public List<Movie> getAllMovies(int pageSize) {
        List<Long> movieIds = new ArrayList<>();
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < pageSize; i++) {
            movieIds.add(new Long(i));
            System.out.println(new Long(i));
        }
        movieRepository.findAll(movieIds).forEach(movies::add);
        return movies;
    }
}
