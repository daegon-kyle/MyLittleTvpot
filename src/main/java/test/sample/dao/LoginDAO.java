package test.sample.dao;

import org.springframework.stereotype.Repository;

import test.common.dao.AbstractDAO;
import test.sample.model.User;

@Repository("loginDAO")
public class LoginDAO extends AbstractDAO {
	
	public boolean checkAvailId(String userId) {		
		boolean isEmpty = selectOne("checkAvailId", userId).equals(new Integer(1));
		
		if (isEmpty) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void saveUserInfo(User user) {
		insert("saveUserInfo", user);
	}
}
