package edu.training.news_portal.service;

import edu.training.news_portal.beans.RegistrationInfo;
import edu.training.news_portal.beans.User;

public interface UserSecurity {
	
	abstract User signIn(String login, String password) throws ServiceException;
	
	boolean signUp(RegistrationInfo regInfo) throws ServiceException;
	
	User findByEmail(String email) throws ServiceException;

}
