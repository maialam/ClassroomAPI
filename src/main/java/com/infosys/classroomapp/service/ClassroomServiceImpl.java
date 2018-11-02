package com.infosys.classroomapp.service;




import javax.inject.Inject;

import com.infosys.classroom.persistence.ClassroomServiceDB;





public class ClassroomServiceImpl implements ClassroomService {
	
	

	

	@Inject
	private ClassroomServiceDB service;

	public String getAllClassrooms() {
		return service.getAllClassrooms();
	}

	public String addClassroom(String account) {
		return service.createClassroom(account);
	}

	public String deleteClassroom(Long classroomid) {
		return service.deleteClassroom(classroomid);
	}
	
	public String updateClassroom(Long classroomid, String accountToUpdate) {
		return service.updateClassroom(classroomid, accountToUpdate);
	}
	
	public String createClassroom(String account) {
		return service.createClassroom(account);
	}

	public void setRepo(ClassroomServiceDB persist) {
		this.service = persist;
	}
	
	
	public String getClassroom(Long classroomid) {
		return service.getClassroom(classroomid);
	}


	
	

}
