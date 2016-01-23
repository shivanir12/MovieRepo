package com.shivani.citra.controller;

import com.shivani.citra.model.Movie;
import com.shivani.citra.service.MovieService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MovieControllerTest {
    @Test
    public void shouldGetAllMovies() throws Exception {
        MovieService movieService = mock(MovieService.class);

        List<Movie> expectedMovies = new ArrayList<>();
        expectedMovies.add(new Movie(1L, "abc"));

        when(movieService.getAllMovies()).thenReturn(expectedMovies);
        MovieController movieController = new MovieController(movieService);
        List<Movie> actualMovies = movieController.getMovie();

        verify(movieService).getAllMovies();
        assertEquals(expectedMovies, actualMovies);
    }

    @Test
    public void shouldSaveMovie() throws Exception {
        MovieService movieService = mock(MovieService.class);
        Movie movieToSave = new Movie();
        MovieController movieController = new MovieController(movieService);

        Movie expectedMovie = new Movie(1L, "abc");
        when(movieService.saveMovie(movieToSave)).thenReturn(expectedMovie);

        Movie actualMovie = movieController.saveMovie(movieToSave);

        verify(movieService).saveMovie(movieToSave);
        assertEquals(expectedMovie, actualMovie);
    }
}