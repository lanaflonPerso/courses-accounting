package com.intelisoft.courses.accounting.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = { "course", "users", "costCoefficient", "completeLessons" })
@EqualsAndHashCode(callSuper = true, exclude = { "course", "users", "costCoefficient", "completeLessons" })

@Entity
@Table(name = "current_courses")
public class CurrentCourse extends Model {

	private static final long serialVersionUID = -8179107624184931157L;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_courses", referencedColumnName = "id")
	private Course course;

	@ManyToMany(mappedBy = "currentCourses", fetch = FetchType.LAZY)
	private List<User> users = new ArrayList<User>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cost_coefficients", referencedColumnName = "id")
	private CostCoefficient costCoefficient;

	@OneToMany(mappedBy = "currentCours", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
			CascadeType.REFRESH }, orphanRemoval = true)
	private List<CompleteLesson> completeLessons = new ArrayList<CompleteLesson>();

}