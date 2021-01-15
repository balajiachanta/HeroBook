package com.gc.controller;

import com.gc.data.MovieStar;
import com.gc.data.User;
import com.gc.service.GenericService;
import com.gc.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class UserController {


    private UserService userService;
    private GenericService genericService;

    public UserController(UserService userService,GenericService genericService) {
        this.userService = userService;
        this.genericService=genericService;
    }

    @GetMapping(value = "/fan/favlist/{userId}")
    public List<MovieStar> fanFavList(@PathVariable String userId){
        User user = userService.getUserById(userId);
        if(null != user && null != user.getFavStarList()){
            return user.getFavStarList();
        }
        return Collections.EMPTY_LIST;
    }

    @PostMapping(value="/user/add")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addUser(@RequestBody User user){
        MovieStar movieStar = genericService.getStarById(user.getFavStarId());
        user.setFavStarList(Arrays.asList(movieStar));
        userService.addUser(user);
    }

    @DeleteMapping(value = "/deleterFav/{userId}")
    public void deleteFavourite(@PathVariable String userId){
        userService.deleteFavouriteListForUser(userId);
    }
}
