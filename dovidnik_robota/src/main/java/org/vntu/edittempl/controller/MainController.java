package org.vntu.edittempl.controller;
  
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
  
@Controller
public class MainController {
  
    @RequestMapping("/edit")
    public String welcome() {
        return "index";
    }
}
