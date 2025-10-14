package com.example.bootqap.movie;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieRepository repo;

    public MovieService(MovieRepository repo) {
        this.repo = repo;
    }

    public List<Movie> all() {
        return repo.findAll();
    }

    public Movie get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    public Movie create(Movie m) {
        return repo.save(m);
    }

    public Movie update(Long id, Movie m) {
        Movie existing = get(id);
        existing.setTitle(m.getTitle());
        existing.setGenre(m.getGenre());
        existing.setRating(m.getRating());
        existing.setDuration(m.getDuration());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
