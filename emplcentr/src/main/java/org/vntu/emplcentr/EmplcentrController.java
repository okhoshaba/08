package org.vntu.emplcentr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmplcentrController {

  @GetMapping("/geninform")
  public String generalForm(Model model) {
    model.addAttribute("geninform", new GenInform());
    return "geninform";
  }

  @PostMapping("/geninform")
  public String genSubmit(@ModelAttribute GenInform geninform, Model model) {
    model.addAttribute("geninform", geninform);
    if (geninform.getId() > 10L)
	    return "genresult";
    else
	    return "generror";
  }

}
