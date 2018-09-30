package pl.techstyle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.techstyle.model.Course;
import pl.techstyle.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
	
	@Query("Select t.courses From Teacher t where t.id=?1")
	List<Course> getAllCorse(Long id);

	@Query("Select t From Teacher t where t.id=?1")
	Teacher findByIdOne(Long id);

}
