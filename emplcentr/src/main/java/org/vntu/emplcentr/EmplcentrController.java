package org.vntu.emplcentr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    if (geninform.getId() < 0L)
	    return "generrorIdNumber";

    if (geninform.getFullName() == "")
	    return "generrorIdNumber";

    return "genresult";
  }

  @GetMapping("/fulltime")
  public String fullTimeForm(Model model) {
    model.addAttribute("fulltime", new FullTime());
    return "fulltime";
  }

  @PostMapping("/fulltime")
  public String genSubmit(@ModelAttribute FullTime fulltime, Model model) {
    model.addAttribute("fulltime", fulltime);
    return "fulltimeresult";
  }

  @GetMapping("/parttime")
  public String partTimeForm(Model model) {
    model.addAttribute("parttime", new PartTime());
    return "parttime";
  }

  @PostMapping("/parttime")
  public String genSubmit(@ModelAttribute PartTime parttime, Model model) {
    model.addAttribute("parttime", parttime);
    return "parttimeresult";
  }

	@RequestMapping("/test")
	public @ResponseBody String greeting() {
		return "Automated system testing.";
	}

}
