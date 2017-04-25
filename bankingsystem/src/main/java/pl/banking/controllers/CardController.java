package pl.banking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CardController
{
    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("name", "test");
        return "index";
    }
}
