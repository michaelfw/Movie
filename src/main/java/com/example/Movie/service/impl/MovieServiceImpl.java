package com.example.Movie.service.impl;

import com.example.Movie.dto.MovieRequest;
import com.example.Movie.entity.Movie;
import com.example.Movie.repository.MovieRepository;
import com.example.Movie.service.MovieService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public String saveMovie(MovieRequest request) {
        saveToDB(request);
        return "Success";
    }

    @Override
    public String getMovie(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);

        if (movie.isPresent()) {
            return "Success";
        } else {
            return "Data Not Found";
        }
    }

    private void saveToDB(MovieRequest request) {
        Movie movie = new Movie();

        movie.setTitle(request.getTitle());
        movie.setGenre(request.getGenre());
        movie.setDuration(request.getDuration());
        movie.setDirector(request.getDirector());
        movie.setRating(request.getRating());

        movieRepository.save(movie);
    }
}
