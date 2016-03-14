package test.sample.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.sample.dao.UserDAO;
import test.sample.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Resource(name="userDAO")
	private UserDAO userDAO;
	
	@Override
	public User getUserInfo(String userId) throws Exception {
		return userDAO.getUserInfo(userId);
	}
	
}
