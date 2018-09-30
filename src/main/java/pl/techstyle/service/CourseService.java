package pl.techstyle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.techstyle.model.Course;
import pl.techstyle.model.Teacher;
import pl.techstyle.repository.CourseRepository;
import pl.techstyle.repository.TeacherRepository;

@Service
public class CourseService {

	@Autowired
	CourseRepository repoCourse;
	
	@Autowired
	TeacherRepository repoTeacher;
	
	public void saveCourse(Course c, Long id) {
		Teacher t = repoTeacher.findByIdOne(id);
		c.setTeacher(t);
		repoCourse.save(c);
	}
	public List<Course> findAll(){
		return repoCourse.findAll();
	}
	
	public void delete(Long id) {
		repoCourse.deleteById(id);
	}
}
