package com.example.movieappusingrecyclerviewretrofit.Model_Class;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SingleUserInfo {
    @SerializedName("data")
    @Expose
    data data;
    @SerializedName("support")
    @Expose
    support supports;

    public data getData() {
        return data;
    }

    public void setData(data data) {
        this.data = data;
    }

    public support getSupports() {
        return supports;
    }

    public void setSupports(support supports) {
        this.supports = supports;
    }
}
