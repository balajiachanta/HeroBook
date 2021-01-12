package com.gc.heloapi.HeroBook;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeroController {


    @GetMapping("/heros")
    public void listHerosNames(){


    }

}
