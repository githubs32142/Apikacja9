package pl.techstyle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@GetMapping("/")
	public ModelAndView getIndex() {
		ModelAndView m= new ModelAndView();
		m.setViewName("index");
		return m;
	}
}
