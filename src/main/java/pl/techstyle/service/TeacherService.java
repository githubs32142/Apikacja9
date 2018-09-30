package pl.techstyle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.techstyle.model.Course;
import pl.techstyle.model.Teacher;
import pl.techstyle.repository.CourseRepository;
import pl.techstyle.repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	TeacherRepository repo;
	@Autowired
	CourseRepository repoCourse;
	public List<Teacher> getAllTeacher(){
		return repo.findAll();
	}
	
	public void addTeacher(Teacher t) {
		repo.save(t);
	}
	
	public List<Course> getAllCourse(Long id){
		return repo.getAllCorse(id);
	}
	
	public void delete(Long id) {
		List<Course> list= getAllCourse(id);
		list.stream().forEach((t)->{
			repoCourse.delete(t);
		});
		repo.deleteById(id);
	}
}
