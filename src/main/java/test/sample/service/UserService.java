package test.sample.service;

import test.sample.model.User;

public interface UserService {
	User getUserInfo(String userId) throws Exception;
}
