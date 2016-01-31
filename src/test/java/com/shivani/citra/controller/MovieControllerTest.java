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

    @Test
    public void shouldGetSingleMovie() throws Exception {
        MovieService movieService = mock(MovieService.class);
        Long movieId = 1L;

        Movie expectedMovie = new Movie();
        when(movieService.getSingleMovie(movieId)).thenReturn(expectedMovie);

        MovieController movieController = new MovieController(movieService);
        Movie actualMovie = movieController.getSingleMovie(movieId);

        verify(movieService).getSingleMovie(movieId);
        assertEquals(expectedMovie, actualMovie);
    }

    @Test
    public void shouldGetMoviesForSpecificPageSize() throws Exception {
        MovieService movieService = mock(MovieService.class);
        int pageSize = 2;

        List<Movie> expectedList = new ArrayList<>();
        expectedList.add(new Movie(1L, "abc"));
        expectedList.add(new Movie(2L, "def"));
        when(movieService.getAllMovies(pageSize)).thenReturn(expectedList);

        MovieController movieController = new MovieController(movieService);
        List<Movie> actualList = movieController.getMovie(pageSize);

        verify(movieService).getAllMovies(pageSize);
        assertEquals(expectedList, actualList);
    }
}