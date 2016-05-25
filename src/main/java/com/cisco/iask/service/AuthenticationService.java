package com.cisco.iask.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;

import org.mongodb.morphia.Datastore;

import com.cisco.iask.entity.User;
import com.cisco.iask.service.ServicesFactory;

public class AuthenticationService {
	public boolean authenticate(String authCredentials) {

		if (null == authCredentials)
			return false;
		// header value format will be "Basic encodedstring" for Basic
		// authentication. Example "Basic YWRtaW46YWRtaW4="
		final String encodedUserPassword = authCredentials.replaceFirst("Basic"
				+ " ", "");
		String usernameAndPassword = null;
		try {
			byte[] decodedBytes = Base64.getDecoder().decode(
					encodedUserPassword);
			usernameAndPassword = new String(decodedBytes, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		final StringTokenizer tokenizer = new StringTokenizer(
				usernameAndPassword, ":");
		final String username = tokenizer.nextToken();
		final String password = tokenizer.nextToken();

		// we have fixed the userid and password as admin
		// call some UserService/LDAP here
		
		Datastore dataStore = ServicesFactory.getMongoDB();
		
		/*User user = (User) dataStore.createQuery(User.class).field("name")
				.equal(username);*/
		List<User> u = dataStore.find(User.class, "name =", username).asList();
		boolean authenticationStatus = false;
		if (!u.isEmpty())
		{
			authenticationStatus = true;
			System.out.println(u.toString());
		}
		//boolean authenticationStatus = "admin".equals(username)
			//	&& "admin".equals(password);
		return authenticationStatus;
	}

}
