package tmd.pop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class WelcomeController {


    @GetMapping("/")
    public String welcomePage(){
        return "welcome";
    }

    @GetMapping("/error")
    public String showErrorPage() {
        return "error";
    }






}

