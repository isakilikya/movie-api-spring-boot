package dev.patika.movieapispringboot.actor.controller;

import dev.patika.movieapispringboot.actor.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/actor")
public class ActorController {
    private final ActorService service;
}
