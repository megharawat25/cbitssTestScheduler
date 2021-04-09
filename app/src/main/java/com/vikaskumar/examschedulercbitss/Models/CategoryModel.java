package com.vikaskumar.examschedulercbitss.Models;

public class CategoryModel
{
    private String title;
    private int url;

    public CategoryModel(String title, int url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }

    //    private String url, title;
//
//    public CategoryModel(String url, String title) {
//        this.url = url;
//        this.title = title;
//    }
//
//    public CategoryModel() {
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
}
