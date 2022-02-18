package com.example.socialx;

import java.util.ArrayList;

public class MainNews {
    private String status,totalResults;
    private ArrayList<ModalClass> articles;

    public MainNews(String status, String totalResults, ArrayList<ModalClass> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public ArrayList<ModalClass> getArticles() {
        return articles;
    }
}
