package com.example.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.util.JSONPObject;


@Controller
public class GreetingController {
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

    @GetMapping("/")
    public String index(){
        return "greeting";
    }

    @GetMapping("/static")
    public String staticTest(){
        return "redirect:statictest.html";
    }

    @GetMapping("/link")
    public String link(){
        return "redirect:linkpage.html";
    }

    @GetMapping("/words")
    public String words(Model model){
        model.addAttribute("words", words);
        return "words";
    }

    @GetMapping("/article")
    public String article(Model model){
        model.addAttribute("arti", first);
        return "article";
    }

    String[] words = {"these", "are", "the", "words"}; 
    // ArrayList<Article> articles = new ArrayList<>();
    Article first;
    
    public GreetingController(){
        first = new Article("First Article", "Welcome to artipedia. This is our first article. We hope you enjoy your stay.");
        first.addSub("This is a subarticle", "Information for the first subarticle");
    }
}