package com.gc.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gc.data.Hero;
import com.gc.exception.GenericNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/heros")
public class HeroController {

    private List<Hero> heroes;

    @PostConstruct
    private void initializeCustomersData() throws IOException {
        heroes = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        File heroFilePath = new File("src/main/java/com/gc/data/Hero.json");
        heroes = mapper.readValue(heroFilePath, new TypeReference<List<Hero>>() {});
    }

    @GetMapping
    public List<String> listHerosNames() {
        return heroes.stream().map(hero -> hero.getHeroName()).collect(Collectors.toList());
    }

    @GetMapping(value = "/{name}")
    public Hero getHeroByName(@PathVariable String name) throws  GenericNotFoundException {
        return heroes.stream().filter(hero -> hero.getHeroName().equals(name)).
                findFirst().
                orElseThrow(() -> new GenericNotFoundException("Hero does not Exist"));
    }



}
