package com.example.movieappusingrecyclerviewretrofit.Model_Class;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpinData {

    private String FullName;
    private String Designation;

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }
}

