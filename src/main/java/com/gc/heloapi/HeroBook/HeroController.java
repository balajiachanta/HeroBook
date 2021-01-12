package com.gc.heloapi.HeroBook;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/heros")
public class HeroController {

    @GetMapping
    public List<String> listHerosNames(){
        List<String> heroList = new ArrayList<>();
        heroList.add("superman");
        heroList.add("spiderman");
        return heroList;
    }



}
