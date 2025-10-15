package edu.training.news_portal.service.impl;

import edu.training.news_portal.beans.RegistrationInfo;
import edu.training.news_portal.beans.User;
import edu.training.news_portal.dao.DaoException;
import edu.training.news_portal.dao.DaoProvider;
import edu.training.news_portal.dao.UserDao;
import edu.training.news_portal.dao.util.DictionaryCache;
import edu.training.news_portal.service.ServiceException;
import edu.training.news_portal.service.UserSecurity;
import edu.training.news_portal.util.RegistrationValidator;

public class NewsPortalUserSecurity implements UserSecurity {

	private final UserDao userDao = DaoProvider.getInstance().getUserDao();

	@Override
	public User signIn(String email, String password) throws ServiceException {

		if (email == null || password == null || email.isBlank() || password.isBlank()) {
			throw new ServiceException("Email и пароль не могут быть пустыми");
		}

		try {
			User user = userDao.checkControl(email, password);

			if (user == null) {
				return null;
			}

			// Проверяем статус пользователя (например, заблокирован)
			if (user.getStatusId() == DictionaryCache.USER_STATUS_BLOCKED_ID) {
				throw new ServiceException("Пользователь заблокирован");
			}

			return user;

		} catch (DaoException e) {
			throw new ServiceException("Ошибка при входе пользователя", e);
		}
	}

	@Override
	public boolean signUp(RegistrationInfo regInfo) throws ServiceException {

		try {

			if (!RegistrationValidator.isValid(regInfo)) {
				System.out.println("Email valid: " + RegistrationValidator.isValidEmail(regInfo.getEmail()));
				System.out.println("Password valid: " + RegistrationValidator.isValidPassword(regInfo.getPassword()));
				System.out.println("Name valid: " + RegistrationValidator.isValidName(regInfo.getName()));
				System.out.println("Surname valid: " + RegistrationValidator.isValidSurname(regInfo.getSurname()));
				throw new ServiceException("Некорректные данные при регистрации");
			}

			return userDao.registration(regInfo);

		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	public User findByEmail(String email) throws ServiceException {
	    if (email == null || email.isBlank()) {
	        return null;
	    }
	    try {
	        return userDao.findByEmail(email); // метод в DAO ищет пользователя по email
	    } catch (DaoException e) {
	        throw new ServiceException("Ошибка при поиске пользователя по email", e);
	    }
	}

}
