package com.gc.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gc.data.Hero;
import com.gc.data.MovieStar;
import com.gc.data.Villan;
import com.gc.exception.GenericNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenericService {


    private List<Hero> heroes;
    private List<Villan> villans;
    private List<MovieStar> movieStarList;

    @Autowired
    private ObjectMapper mapper;

    @PostConstruct
    private void initializeCustomersData() throws IOException {
        heroes = new ArrayList<>();
        File heroFilePath = new File("src/main/java/com/gc/data/Hero.json");
        heroes = mapper.readValue(heroFilePath, new TypeReference<List<Hero>>() {});
        File villanFilePath = new File("src/main/java/com/gc/data/villan.json");
        villans = mapper.readValue(villanFilePath, new TypeReference<List<Villan>>() {});
        movieStarList = new ArrayList<>();
        movieStarList.addAll(heroes);
        movieStarList.addAll(villans);

    }

    public List<String> listHeroNames(){
        return heroes.stream().map(hero -> hero.getHeroName()).collect(Collectors.toList());
    }


    public Hero getHeroByName(String name) throws GenericNotFoundException {
        return heroes.stream().filter(hero -> hero.getHeroName().equals(name)).
                findFirst().
                orElseThrow(() -> new GenericNotFoundException("Hero does not Exist"));
    }

    public List<String> listVillanNames(){
        return villans.stream().map(hero -> hero.getVillanName()).collect(Collectors.toList());
    }


    public Villan getVillanByName(String name) throws GenericNotFoundException {
        return villans.stream().filter(villan -> villan.getVillanName().equals(name)).
                findFirst().
                orElseThrow(() -> new GenericNotFoundException("Villan does not Exist"));
    }

    public MovieStar getStarById(String starId){
        return movieStarList.stream().filter(star -> star.getId().equals(starId)).
                findFirst().orElse(new MovieStar());
    }


}
