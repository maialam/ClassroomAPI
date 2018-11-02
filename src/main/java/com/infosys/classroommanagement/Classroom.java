package com.infosys.classroommanagement;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//EVERYTHING FIXED
@Entity
public class Classroom {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long classroomid;
	@Column(length = 100)
	private String trainer;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Trainee> trainee;
	private String classNumber;

	public Classroom() {

	}

	public List<Trainee> getTrainee() {
		return trainee;
	}

	public void setTrainee(List<Trainee> trainee) {
		this.trainee = trainee;
	}

	public Long getClassroomid() {
		return classroomid;
	}

	public void setClassroomid(Long classroomid) {
		this.classroomid = classroomid;
	}

	public String getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public String getClassroomNumber() {
		return classNumber;
	}

	public void setClassroomNumber(String classNumber) {
		this.classNumber = classNumber;
	}

	public String giveAccount() {
		return "Account [Trainer=" + trainer + ", Trainees=" + ", accountNumber=" + classNumber + "]";
	}

}
