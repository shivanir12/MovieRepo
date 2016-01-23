package com.shivani.citra.service;

import com.shivani.citra.model.Movie;
import com.shivani.citra.repository.MovieRepository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MovieServiceTest {

    @Test
    public void shouldGetAllMovies() throws Exception {
        List<Movie> expectedMovies = new ArrayList<>();
        expectedMovies.add(new Movie(1L, "abc"));

        MovieRepository movieRepository = mock(MovieRepository.class);
        MovieService movieService = new MovieService(movieRepository);
        when(movieRepository.findAll()).thenReturn(expectedMovies);

        List<Movie> movies = movieService.getAllMovies();

        assertEquals(expectedMovies, movies);
        verify(movieRepository).findAll();
    }
}