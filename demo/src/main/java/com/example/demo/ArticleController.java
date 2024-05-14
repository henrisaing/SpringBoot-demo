package com.example.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.util.JSONPObject;


@Controller
public class ArticleController {
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

    @GetMapping("/articles")
    public String articles(Model model){
        model.addAttribute("arti", articles.get(0));
        return "article";
    }

    @GetMapping("/article")
	public String article(@RequestParam(name="name", required=false, defaultValue="Home") String name, Model model) {
        Article found = articles.get(0);
        for (Article article : articles){
            if(article.name().equals(name)){
                found = article;
            }
        }
            model.addAttribute("arti", found);
		
		return "article";
	}

    String[] words = {"these", "are", "the", "words"}; 
    ArrayList<Article> articles = new ArrayList<>();
    
    
    public ArticleController(){
        Article home, attributes;
        home = new Article("Home", "Welcome to artipedia. This is our first article. We hope you enjoy your stay.", "https://i.ibb.co/sbwdY5s/guild-wars-guild-wars-2-creepy-necromancer-wallpaper-preview.jpg");
        home.addSub("This is a subarticle", "Information for the first subarticle");
        home.addSub("Attack Patterns", "Freya has a mix of healing, minion support, and AoE attacks.");
        home.addSub("Loot", "This boss drops the following loot.\n  -Ball\n  -Sword");
        home.addSub("Lotta Text", "This subarticle is just word vomit. I'm just testing the limits to java strings. How long can they go?");
        home.addSub("Zoo", "Is this reverse alphabetical?");
        home.addSub("Loot2", "This boss drops the following loot.\n  -Ball\n  -Sword");

        attributes = new Article("Attributes", "This system uses the same attributes as the traditional DnD system, but the attributes are used differently.");
        attributes.addSub("Strength", "Physical attack modifier. Adds flat damage to physical attacks.");
        attributes.addSub("Dexterity", "Physical attack modifier. Adds haste to physical attacks (extra D's).");
        
        articles.add(home);
        articles.add(attributes);
    };
}