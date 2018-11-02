package com.infosys.classroommanagement;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class ClassroomAccount {




		

		@Id @GeneratedValue(strategy=GenerationType.AUTO)
	//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
		private Long classroomid;
		@Column(length = 100)
		private String trainer;
		@Column(length = 50)
		private String traineeName;
		@Column(length=4)
		private String classNumber;

		

		public ClassroomAccount() {
			
		}


//		public ClassroomAccount(String firstName, String lastName, String accountNumber) {
//			super();
//			this.firstName = firstName;
//			this.lastName = lastName;
//			this.classNumber = classNumber;
//		}
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

		public String getTraineeName() {
			return traineeName;
		}

		public void setTraineeName(String traineeName) {
			this.traineeName = traineeName;
		}

		public String getAccountNumber() {
			return classNumber;
		}

		public void setAccountNumber(String classNumber) {
			this.classNumber = classNumber;
		}

		public String giveAccount() {
			return "Account [Trainer=" + trainer + ", Trainees=" + traineeName + ", accountNumber=" + classNumber + "]";
		}

	}
	
	

