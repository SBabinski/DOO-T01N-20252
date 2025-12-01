package com.tvtracker.model;

import java.util.ArrayList;
import java.util.List;

public class UserData {
    public String username;
    public List<Series> favorites = new ArrayList<>();
    public List<Series> watched = new ArrayList<>();
    public List<Series> toWatch = new ArrayList<>();

    public UserData() {}

    public UserData(String username) {
        this.username = username;
    }
}
