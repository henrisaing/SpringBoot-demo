package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}