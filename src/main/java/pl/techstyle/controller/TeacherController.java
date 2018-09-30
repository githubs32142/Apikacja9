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

import pl.techstyle.model.Teacher;
import pl.techstyle.service.TeacherService;

/**
 * @author Admin
 *
 */
@Controller
@RequestMapping(value="/teacher")
public class TeacherController {

	@Autowired
	TeacherService serviceTeacher;
	
	@GetMapping(value="/all")
	public ModelAndView getAllTeacher() {
		ModelAndView m = new ModelAndView();
		m.addObject("teachers",serviceTeacher.getAllTeacher());
		m.setViewName("allTeacher");
		return m;
	}
	
	@GetMapping(value="/course/all")
	public ModelAndView getAllCourse(@RequestParam(value="id") Long id) {
		ModelAndView m = new ModelAndView();
		m.addObject("courses",serviceTeacher.getAllCourse(id));
		m.setViewName("allCourse");
		return m;
	}

	
	@GetMapping(value="/add")
	public ModelAndView getTeacher() {
		ModelAndView m = new ModelAndView();
		m.addObject("teacher",new Teacher());
		m.setViewName("addTeacher");
		return m;
	}
	@PostMapping(value="/add")
	public ModelAndView addTeacher(@Valid Teacher t, BindingResult br) {
		ModelAndView m = new ModelAndView();
		System.out.println(t.toString());
		serviceTeacher.addTeacher(t);
		m.addObject("teacher",new Teacher());
		m.setViewName("addTeacher");
		return m;
	}

	@DeleteMapping(value="/")
	public ModelAndView deleteTeacher(@RequestParam(value="id") Long id) {
		ModelAndView m = new ModelAndView();
		serviceTeacher.delete(id);
		m.addObject("teachers",serviceTeacher.getAllTeacher());
		m.setViewName("allTeacher");
		return m;
	}
	
}
