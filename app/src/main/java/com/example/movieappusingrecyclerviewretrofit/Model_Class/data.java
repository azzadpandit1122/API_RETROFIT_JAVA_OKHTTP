package com.example.movieappusingrecyclerviewretrofit.Model_Class;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class data {
    @SerializedName("id")
    @Expose
    String id;
    @SerializedName("email")
    @Expose
    String  email;
    @SerializedName("first_name")
    @Expose
    String  first_name;
    @SerializedName("last_name")
    @Expose
    String  last_name;
    @SerializedName("avatar")
    @Expose
    String  avatar;

    public data(String id, String email, String first_name, String last_name, String avatar) {
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
