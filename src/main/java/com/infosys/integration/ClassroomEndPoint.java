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

	@Path("/getAllAccounts")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
		return service.getAllAccounts();
	}

	@Path("/addAccount")
	@POST
	@Produces({ "application/json" })
	public String createAccount(String account) {
		return service.createAccount(account);
	}

	@Path("/deleteAccount/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") Long classroomid) {
		return service.deleteAccount(classroomid);
	}
	@Path("/getAccount/{id}")
	@GET
	@Produces({ "application/json" })
	public String getAccount(@PathParam("id") Long classroomid) {
		return service.getAccount(classroomid);
	}
	@Path("/updateAccount/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("id") Long classroomid, String accountToUpdate){
		return service.updateAccount(classroomid, accountToUpdate);
	}
	public void setService(ClassroomService service) {
		this.service = service;
	}
	
}
