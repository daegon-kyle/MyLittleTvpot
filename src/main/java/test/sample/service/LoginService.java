package test.sample.service;

import test.sample.model.User;

public interface LoginService {
	boolean checkAvailId(String userId) throws Exception;
	void saveUserInfo(User user) throws Exception;
}
