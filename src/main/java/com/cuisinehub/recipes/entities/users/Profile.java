package com.cuisinehub.recipes.entities.users;

import java.io.Serializable;
import java.util.Date;

import com.cuisinehub.recipes.DTOs.users.UserBasicResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "profile")
public class Profile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Integer id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = true, length = 50)
    private String firstName;

    @Column(nullable = true, length = 50)
    private String lastName;

    @Column(nullable = true)
    private String photo;

    @Column(nullable = true)
    private String bio;

    @Column(nullable = true)
    private Date birthday;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Empty Constructor
    public Profile() {

    }

    // Converts ProfileEntity to UserBasicResponse
    public UserBasicResponse toUserBasicResponse(){

        // Instantiates a UserBasicResponse empty object
        UserBasicResponse response = new UserBasicResponse();

        // Populate it with data
        response.setId(id);
        response.setUserPhoto(photo);
        response.setUsername(userName);

        return response;

    }


    // Setters and Getters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public User getUser() {
        return user;
    }

    public void setLogin(User user) {
        this.user = user;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /* ---------------------- Overriden methods ---------------------- */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Profile other = (Profile) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Profile [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", photo=" + photo
                + ", bio=" + bio + ", user=" + user + "]";
    }

}
