package test.sample.dao;

import org.springframework.stereotype.Repository;

import test.common.dao.AbstractDAO;
import test.sample.model.User;

@Repository("userDAO")
public class UserDAO extends AbstractDAO{
	
	public User getUserInfo(String userId) throws Exception{
		return (User)selectOne("getUserInfo", userId);
	}
}
