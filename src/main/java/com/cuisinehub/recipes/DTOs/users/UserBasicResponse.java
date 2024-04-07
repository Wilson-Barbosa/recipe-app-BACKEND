package com.cuisinehub.recipes.DTOs.users;

public class UserBasicResponse {
    
    private int id;
    private String username;
    private String userPhoto;

    // Empty Constructor
    public UserBasicResponse(){
        
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUserPhoto() {
        return userPhoto;
    }
    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }


}
