package com.shivani.citra;

import com.shivani.citra.model.Movie;
import com.shivani.citra.repository.MovieRepository;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.stream.Stream;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        MovieRepository movieRepository = ctx.getBean(MovieRepository.class);

        File seedDirectory = new File(ClassLoader.getSystemClassLoader().getResource("seed").toURI());

        Arrays.stream(seedDirectory.listFiles()).forEach(file -> {
            try {
                JSONObject jsonObject = new JSONObject(new JSONTokener(new FileReader(file)));
                movieRepository.save(new Movie(jsonObject.getString("title")));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });

        Stream.of(movieRepository.findAll()).forEach(movies -> System.out.println(movies.toString()));

    }

}