package com.gc.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gc.data.Hero;
import com.gc.data.Villan;
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
@RequestMapping("/villans")
public class VillanController {

    private List<Villan> villans;

    @PostConstruct
    private void initializeCustomersData() throws IOException {
        villans = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        File heroFilePath = new File("src/main/java/com/gc/data/villan.json");
        villans = mapper.readValue(heroFilePath, new TypeReference<List<Villan>>() {});
    }

    @GetMapping
    public List<String> listVillanNames() {
        return villans.stream().map(villan -> villan.getVillanName()).collect(Collectors.toList());
    }

    @GetMapping(value = "/{name}")
    public Villan getVillanByName(@PathVariable String name) {
        return villans.stream().filter(villan -> villan.getVillanName().equals(name)).findFirst().get();
    }



}
