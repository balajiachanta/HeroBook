package com.gc.data;


import java.util.List;
import java.util.Objects;

public class User {

    private String id;
    private String name;
    private String role;
    private String favStarId;
    private List<MovieStar> favStarList;

    public List<MovieStar> getFavStarList() {
        return favStarList;
    }

    public void setFavStarList(List<MovieStar> favStarList) {
        this.favStarList = favStarList;
    }

    public String getFavStarId() {
        return favStarId;
    }

    public void setFavStarId(String favStarId) {
        this.favStarId = favStarId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
