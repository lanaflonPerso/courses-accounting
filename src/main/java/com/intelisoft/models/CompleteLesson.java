package com.intelisoft.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "complete_lessons")
public class CompleteLesson extends Model {

	private static final long serialVersionUID = 7516951076959772739L;

	@Column(name = "date", nullable = false)
	private Date date;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_current_courses", referencedColumnName = "id")
	private CurrentCourse currentCours;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_lessons", referencedColumnName = "id")
	private Lesson lesson;

	@ManyToMany(mappedBy = "completeLessons", fetch = FetchType.EAGER)
	private List<User> users = new ArrayList<User>();

}