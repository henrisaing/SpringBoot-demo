package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class Article {
    private String name;
    private String article;
    private Map<String, String> subArticle = new HashMap<>();
    
    public Article(String articleName){
        name = articleName;
        article = "";
    }

    public Article(String articleName, String info){
        name = articleName;
        article = info;
    }

    public void addSub(String subName, String subinfo){
        subArticle.put(subName, subinfo);
    }

    public String name(){
        return name;
    }

    public String info(){
        return article;
    }

    public Map<String, String> subs(){
        return subArticle;
    }
}
