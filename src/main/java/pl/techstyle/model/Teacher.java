package pl.techstyle.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Nauczyciel")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_nauczyciela")
	Long id;
	
	@NotNull(message="Musisz wprowadzić imie!")
	@Column(name="Imie")
	String name;
	
	@NotNull(message="Musisz wprowadzić nazwisko!")
	@Column(name="Nazwisko")
	String surName;
	
	@NotNull(message="Musisz wprowadzić tytuł!")
	@Column(name="Tytul")
	String degree;
	
	@OneToMany(mappedBy="teacher",cascade = CascadeType.ALL )
	List<Course> courses;
}
