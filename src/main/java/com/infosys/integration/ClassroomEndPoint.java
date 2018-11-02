package com.infosys.integration;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


import org.apache.log4j.Logger;

import com.infosys.classroomapp.service.ClassroomService;

@Path("/classroom")
public class ClassroomEndPoint{

	@Inject
	private ClassroomService service;

	@Path("/getAllClassrooms")
	@GET
	@Produces({ "application/json" })
	public String getAllClassrooms() {
		return service.getAllClassrooms();
	}

	@Path("/addClassroom")
	@POST
	@Produces({ "application/json" })
	public String createClassroom(String account) {
		return service.createClassroom(account);
	}

	@Path("/deleteClassroom/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteClassroom(@PathParam("id") Long classroomid) {
		return service.deleteClassroom(classroomid);
	}
	@Path("/getClassroom/{id}")
	@GET
	@Produces({ "application/json" })
	public String getClassroom(@PathParam("id") Long classroomid) {
		return service.getClassroom(classroomid);
	}
	@Path("/updateClassroom/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateClassroom(@PathParam("id") Long classroomid, String accountToUpdate){
		return service.updateClassroom(classroomid, accountToUpdate);
	}
	public void setService(ClassroomService service) {
		this.service = service;
	}
	
}
