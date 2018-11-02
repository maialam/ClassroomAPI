package com.infosys.classroomapp.service;




import javax.inject.Inject;

import com.infosys.classroom.persistence.ClassroomServiceDB;





public class ClassroomServiceImpl implements ClassroomService {
	
	

	

	@Inject
	private ClassroomServiceDB service;

	public String getAllAccounts() {
		return service.getAllAccounts();
	}

	public String addAccount(String account) {
		return service.createAccount(account);
	}

	public String deleteAccount(Long classroomid) {
		return service.deleteAccount(classroomid);
	}
	
	public String updateAccount(Long classroomid, String accountToUpdate) {
		return service.updateAccount(classroomid, accountToUpdate);
	}
	
	public String createAccount(String account) {
		return service.createAccount(account);
	}

	public void setRepo(ClassroomServiceDB persist) {
		this.service = persist;
	}
	
	
	public String getAccount(Long classroomid) {
		return service.getAccount(classroomid);
	}


	
	

}
