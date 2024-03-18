package comp74.sakila.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import comp74.sakila.model.entities.Actor;
import comp74.sakila.model.entities.Film;
import comp74.sakila.model.repos.ActorRepo;
import comp74.sakila.model.repos.FilmRepo;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MainController {

    ActorRepo actorRepo;
    FilmRepo filmRepo;

    public MainController(ActorRepo actorRepo, FilmRepo filmRepo) {
        this.actorRepo = actorRepo;
        this.filmRepo = filmRepo;
    }

    // @GetMapping("/actors")
    // public Page<Actor> getActors() {
    // PageRequest pageRequest = PageRequest.of(1, 5);
    // Page<Actor> actors = actorRepo.findAll(pageRequest);
    // return actors;
    // }

    @GetMapping("/actors")
    public Page<Actor> getActors(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int pagesize) {
        PageRequest pageRequest = PageRequest.of(page, pagesize);
        return actorRepo.findAll(pageRequest);
    }

    // TODO
    // Add code to /films endpoint to get page of films
    // @GetMapping("/films")

    @GetMapping("/films")
    public Page<Film> getFilms(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int pagesize) {
        PageRequest pageRequest = PageRequest.of(page, pagesize);
        return filmRepo.findAll(pageRequest);
    }

}
