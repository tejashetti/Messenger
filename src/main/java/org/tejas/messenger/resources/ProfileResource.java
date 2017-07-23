package org.tejas.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.tejas.messenger.model.Profile;
import org.tejas.messenger.service.ProfileService;


@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	ProfileService ps= new ProfileService();
	
	@GET
	public List<Profile> getProfiles()
	{
		return ps.getAllProfiles();
	}
	
	@Path("/{profileName}")
	@GET
	public Profile getProfile(@PathParam("profileName")String profileName)
	{
		return ps.getProfile(profileName);
	}
	
	@POST
	public Profile addProfile(Profile profile)
	{
		return ps.addProfile(profile);
	}
	
	@PUT
	public Profile updateProfile(Profile profile)
	{
	
		return ps.updateProfile(profile);
	} 
	
	@DELETE
	@Path("/{profileName}")
	public Profile deleteProfile(@PathParam("profileName") String profileName)
	{
		return ps.removeProfile(profileName);
	}

}
