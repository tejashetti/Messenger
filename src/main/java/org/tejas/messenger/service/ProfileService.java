package org.tejas.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.tejas.messenger.database.Database;
import org.tejas.messenger.model.Profile;

public class ProfileService {
	
	public ProfileService() {
		// TODO Auto-generated constructor stub
		profiles.put("ts", new Profile(1L, "ts", "Tejas", "Shetti"));
	}
	private Map<String, Profile> profiles=Database.getProfiles();
	
	public List<Profile> getAllProfiles()
	{
		return new ArrayList<>(profiles.values());
	}
	public Profile getProfile(String username)
	{
		return profiles.get(username);
	}
	
	public Profile addProfile(Profile profile)
	{
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile)
	{
		if(profile.getProfileName().isEmpty())
			return null;
		profiles.put(profile.getProfileName(), profile);
			
		return profile;
	}
	
	public Profile removeProfile(String profileName)
	{
		return profiles.remove(profileName);
	}

}
