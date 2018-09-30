package pl.techstyle.model;

import java.sql.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Kurs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_kursu")
	Long id;
	
	@Column(name="Nazwa_kursu")
	String nameCourse;
	
	@Column(name="Data_rozpoczecia")
	@JsonFormat(pattern="yyyy-MM-dd")
	Date dateStart;
	
	@Column(name="Data_zakonczenia")
	@JsonFormat(pattern="yyyy-MM-dd")
	Date dateEnd;

	@ManyToOne
	@JoinColumn(name="id_nauczyciela", nullable=false)
	Teacher teacher;
}
