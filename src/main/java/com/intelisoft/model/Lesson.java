package com.intelisoft.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lessons")
public class Lesson extends Model{

	private static final long serialVersionUID = -1666874779326644816L;

	@Column(name = "sequence_number", nullable = false)
	private Short sequenceNumber;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "lesson")
	private List<Topic> topics = new ArrayList<Topic>();
	
	@ManyToOne
	@JoinColumn(name = "id_courses", referencedColumnName = "id")
	private Course course;
	
	@OneToMany(mappedBy = "lesson")
	private List<CompleteLesson> completeLessons = new ArrayList<CompleteLesson>();
	
	public Lesson() {
	}

	public Lesson(Short sequenceNumber, String name, List<Topic> topics, Course course,
			List<CompleteLesson> completeLessons) {
		super();
		this.sequenceNumber = sequenceNumber;
		this.name = name;
		this.topics = topics;
		this.course = course;
		this.completeLessons = completeLessons;
	}

	public Short getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(Short sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<CompleteLesson> getCompleteLessons() {
		return completeLessons;
	}

	public void setCompleteLessons(List<CompleteLesson> completeLessons) {
		this.completeLessons = completeLessons;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Lesson [id=");
		builder.append(id);
		builder.append(", sequenceNumber=");
		builder.append(sequenceNumber);
		builder.append(", name=");
		builder.append(name);
		builder.append(", topics=");
		builder.append(topics);
		builder.append(", course=");
		builder.append(course);
		builder.append(", completeLessons=");
		builder.append(completeLessons);
		builder.append("]");
		return builder.toString();
	}

}
