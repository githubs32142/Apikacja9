package pl.techstyle.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.techstyle.model.Course;
import pl.techstyle.service.CourseService;

@Controller
@RequestMapping(value="/course")
public class CourseController {

	@Autowired
	CourseService service;
	
	@GetMapping(value="/add")
	public ModelAndView addCourse(@RequestParam(value="id", required=true) Long id){
		ModelAndView m = new ModelAndView();
		m.addObject("course",new Course());
		m.addObject("id",id);
		m.setViewName("addCourse");
		return m;
		
	}
	@PostMapping(value="/add")
	public ModelAndView add(@Valid Course c, BindingResult b, @RequestParam(value="id", required=true) Long id){
		ModelAndView m = new ModelAndView();
	    
		System.out.println(c.toString());
		service.saveCourse(c, id);
		m.addObject("course",new Course());
		m.addObject("id",id);
		m.setViewName("addCourse");
		return m;
		
	}
	@GetMapping(value="/all")
	public ModelAndView getAllCourse() {
		ModelAndView m = new ModelAndView();
		m.addObject("courses",service.findAll());
		m.setViewName("allCourse");
		return m;
	}
	@DeleteMapping(value="/")
	public ModelAndView deleteCourse(@RequestParam(value="id") Long id) {
		ModelAndView m = new ModelAndView();
		service.delete(id);
		m.addObject("courses",service.findAll());
		m.setViewName("allCourse");
		return m;
	}
}
