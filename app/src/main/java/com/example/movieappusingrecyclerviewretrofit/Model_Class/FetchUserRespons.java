package com.example.movieappusingrecyclerviewretrofit.Model_Class;

import java.util.List;

public class FetchUserRespons {
    List<com.example.movieappusingrecyclerviewretrofit.Model_Class.data> data;
    List<support> supports;

    public FetchUserRespons(List<data> data, List<support> supports) {
        this.data = data;
        this.supports = supports;
    }

    public List<data> getData() {
        return data;
    }

    public void setData(List<data> data) {
        this.data = data;
    }

    public List<support> getSupports() {
        return supports;
    }

    public void setSupports(List<support> supports) {
        this.supports = supports;
    }
}
