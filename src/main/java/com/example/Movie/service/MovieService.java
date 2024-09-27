package com.example.Movie.service;

import com.example.Movie.dto.MovieRequest;

public interface MovieService {

    String saveMovie(MovieRequest request);

    String getMovie(Long id);
}
