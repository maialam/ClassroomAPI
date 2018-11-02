package com.infosys.classroomapp.service;

public interface ClassroomService {


	String getAllAccounts();

	String createAccount(String account);

	String updateAccount(Long classroomid, String accountToUpdate);

	String deleteAccount(Long classroomid);

	String getAccount(Long classroomid);


	
	
}
