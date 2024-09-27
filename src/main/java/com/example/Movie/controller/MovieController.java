package com.example.Movie.controller;

import com.example.Movie.dto.MovieRequest;
import com.example.Movie.service.MovieService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping(value = "/add_movie")
    public String addMovie(@RequestBody MovieRequest request) {
        return movieService.saveMovie(request);
    }

    @GetMapping(value = "/get_movie/{id}")
    public String getDataMovieById(@PathVariable Long id) {
        return movieService.getMovie(id);
    }
}
