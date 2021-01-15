package com.gc.controller;

import com.gc.data.Villan;
import com.gc.exception.GenericNotFoundException;
import com.gc.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/villans")
public class VillanController {

    @Autowired
    private GenericService genericService;

    @GetMapping
    public List<String> listVillanNames() {
        return genericService.listVillanNames();
    }

    @GetMapping(value = "/{name}")
    public Villan getVillanByName(@PathVariable String name) throws GenericNotFoundException {
        return genericService.getVillanByName(name);
    }



}
