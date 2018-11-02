package com.infosys.classroommanagement;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



@Entity
public class ClassroomAccount {




		
		@Id @GeneratedValue(strategy=GenerationType.AUTO)
		private Long classroomid;
		@Column(length = 100)
		private String firstName;
		@Column(length = 50)
		private String lastName;
		@Column(length = 4)
		private String classNumber;
		@JoinColumn
		@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
		

		public ClassroomAccount() {
			
		}


//		public ClassroomAccount(String firstName, String lastName, String accountNumber) {
//			super();
//			this.firstName = firstName;
//			this.lastName = lastName;
//			this.classNumber = classNumber;
//		}
		
		public Long getId() {
			return classroomid;
		}
		
		public void setId(Long id) {
			this.classroomid = id;
		}


		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getAccountNumber() {
			return classNumber;
		}

		public void setAccountNumber(String accountNumber) {
			this.classNumber = accountNumber;
		}

		public String giveAccount() {
			return "Account [firstName=" + firstName + ", surname=" + lastName + ", accountNumber=" + classNumber + "]";
		}

	}
	
	

