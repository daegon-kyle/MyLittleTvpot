package test.sample.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.sample.dao.LoginDAO;
import test.sample.model.User;

@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService{
	
	@Resource(name="loginDAO")
	private LoginDAO loginDAO;
	
	@Override
	public boolean checkAvailId(String userId) throws Exception {
		return loginDAO.checkAvailId(userId);
	}
	
	@Override
	public void saveUserInfo(User user) throws Exception {
		loginDAO.saveUserInfo(user);
	}
}
