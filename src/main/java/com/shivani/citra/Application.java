package com.shivani.citra;

import com.shivani.citra.model.Movie;
import com.shivani.citra.repository.MovieRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//import java.util.Arrays;
import java.util.stream.Stream;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        MovieRepository movieRepository = ctx.getBean(MovieRepository.class);

        movieRepository.save(new Movie("Spectre"));

        Stream.of(movieRepository.findAll()).forEach(movie -> System.out.println(movie.toString()));

//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
    }

}