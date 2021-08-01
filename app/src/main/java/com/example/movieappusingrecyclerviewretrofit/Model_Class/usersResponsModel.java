package com.example.movieappusingrecyclerviewretrofit.Model_Class;

import java.util.List;

public class usersResponsModel {
    String page,per_page,total,total_pages;
    List<data> data;
    List<support> supports;

    public usersResponsModel(String page, String per_page, String total, String total_pages, List<data> data, List<support> supports) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
        this.supports = supports;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPer_page() {
        return per_page;
    }

    public void setPer_page(String per_page) {
        this.per_page = per_page;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(String total_pages) {
        this.total_pages = total_pages;
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
