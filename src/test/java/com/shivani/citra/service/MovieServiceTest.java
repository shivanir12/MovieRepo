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
    public void shouldSaveMovie() throws Exception {
        MovieRepository movieRepository = mock(MovieRepository.class);
        Movie movieToSave = new Movie("abc");
        Movie expectedMovie = new Movie(1L, "abc");
        MovieService movieService = new MovieService(movieRepository);

        when(movieRepository.save(movieToSave)).thenReturn(expectedMovie);

        Movie actualMovie = movieService.saveMovie(movieToSave);

        verify(movieRepository).save(movieToSave);
        assertEquals(actualMovie, expectedMovie);
    }

    @Test
    public void shouldGetSingleMovie() throws Exception {
        MovieRepository movieRepository = mock(MovieRepository.class);
        Long movieId = 1L;
        Movie expectedMovie = new Movie(1L, "abc");
        when(movieRepository.findOne(movieId)).thenReturn(expectedMovie);

        MovieService movieService = new MovieService(movieRepository);
        Movie actualMovie = movieService.getSingleMovie(movieId);

        verify(movieRepository).findOne(movieId);
        assertEquals(expectedMovie, actualMovie);
    }

    @Test
    public void shouldReturnMovieListSpecifiedByPageSize() throws Exception {
        MovieRepository movieRepository = mock(MovieRepository.class);
        int pageSize = 2;
        List<Movie> expectedMovies = new ArrayList<>();
        expectedMovies.add(new Movie(1L, "abc"));
        List<Long> movieIds = new ArrayList<>();
        movieIds.add(0L);
        movieIds.add(1L);
        when(movieRepository.findAll(movieIds)).thenReturn(expectedMovies);

        MovieService movieService = new MovieService(movieRepository);
        List<Movie> actualMovies = movieService.getAllMovies(pageSize);

        verify(movieRepository).findAll(movieIds);
        assertEquals(expectedMovies, actualMovies);
    }
}