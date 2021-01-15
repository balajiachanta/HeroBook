package com.gc.controller;

import com.gc.data.Hero;
import com.gc.exception.GenericNotFoundException;
import com.gc.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/heros")
public class HeroController {

    @Autowired
    private GenericService genericService;

    @GetMapping
    public List<String> listHerosNames() {
        return genericService.listHeroNames();
    }

    @GetMapping(value = "/{name}")
    public Hero getHeroByName(@PathVariable String name) throws GenericNotFoundException {
       return genericService.getHeroByName(name);
    }



}
