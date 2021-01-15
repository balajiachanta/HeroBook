package com.gc.service;

import com.gc.data.MovieStar;
import com.gc.data.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private List<User> users;

    @PostConstruct
    public void init(){
        users = new ArrayList<>();
    }

    public void addUser(User user){
        users.add(user);
    }

    public User getUserById(String id){
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(new User());
    }

    public void deleteFavouriteListForUser(String userId){
        User user = this.getUserById(userId);
        if(null != user && null != user.getFavStarList()){
            user.setFavStarList(null);
        }
    }

    private void updateUser(User user){
        users.remove(user);
        users.add(user);
    }

}
