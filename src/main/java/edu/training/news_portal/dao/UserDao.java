package edu.training.news_portal.dao;

import edu.training.news_portal.beans.RegistrationInfo;
import edu.training.news_portal.beans.User;

public interface UserDao {
	
	User checkControl(String login, String password) throws DaoException;
	
	boolean registration(RegistrationInfo regInfo) throws DaoException;

	User findByEmail(String email) throws DaoException;
	
		
	}


