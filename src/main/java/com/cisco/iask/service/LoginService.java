package com.cisco.iask.service;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.mongodb.morphia.Datastore;

import com.cisco.iask.entity.User;
import com.cisco.iask.auth.LoginResponse;


@Path("/auth")
public class LoginService {
	
	@GET
    @Path("/login/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public LoginResponse LoginResponse (
    		@PathParam("username") String username) {
		Datastore dS = ServicesFactory.getMongoDB();
		List<User> u = dS.find(User.class, "name =", username).asList();
        LoginResponse lr = new LoginResponse(u.get(0).getFirstname(),
        		u.get(0).getLastname(), u.get(0).getName());
        return lr;
    }
	
	@POST
	@Path("/signup")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LoginResponse createUser(
			User u
			) {
		
	if(!isUserExisting(u))
	{
		Datastore dS = ServicesFactory.getMongoDB();
		dS.save(u);		
		
		List<User> unew = dS.find(User.class, "name =", u.getName()).asList();
        LoginResponse lr = new LoginResponse(unew.get(0).getFirstname(),
        		unew.get(0).getLastname(), unew.get(0).getName());
        return lr;
	}
	else
	{
		LoginResponse lr = new LoginResponse();
		lr.setErrorMsg("username already exists");
		lr.setSignupDone(false);
		return lr;
	}
	
	}
	
	private boolean isUserExisting(User u) {
		boolean res = false;
		Datastore dS = ServicesFactory.getMongoDB();
		List<User> ulist = dS.find(User.class, "name =", u.getName()).asList();
		
		if(ulist!=null && !ulist.isEmpty()) res=true;
	
		return res;
	}
}
