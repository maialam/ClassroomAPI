package com.infosys.classroom.persistence;

public interface ClassroomServiceDB {
	
	String getAllAccounts();

	String createAccount(String account);

	String updateAccount(Long classroomid, String accountToUpdate);

	String deleteAccount(Long classroomid);

	String getAccount(Long classroomid);


	

}
