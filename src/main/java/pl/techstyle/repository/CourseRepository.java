package pl.techstyle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.techstyle.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
