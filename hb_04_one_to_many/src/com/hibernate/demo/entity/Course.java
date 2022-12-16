package com.hibernate.demo.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@JoinColumn(name="instructor_id")
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
				CascadeType.PERSIST,CascadeType.REFRESH})
	private Instructor instructor;
	
	@JoinColumn(name="course_id")
	@OneToMany(fetch = FetchType.LAZY,cascade =CascadeType.ALL)
	private List<Review> review;
	
	public Course(){}
	

	public Course(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public List<Review> getReview() {
		return review;
	}


	public void setReview(List<Review> review) {
		this.review = review;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", instructor=" + instructor + "]";
	}

	public void addReview (Review review) {
		if(this.review==null)
		this.review=new ArrayList<Review>();
	
		this.review.add(review);
	
}
	
	
}
