package com.infosys.classroom.persistence;

public interface ClassroomServiceDB {
	
	String getAllClassrooms();

	String createClassroom(String account);

	String updateClassroom(Long classroomid, String accountToUpdate);

	String deleteClassroom(Long classroomid);

	String getClassroom(Long classroomid);


	

}
