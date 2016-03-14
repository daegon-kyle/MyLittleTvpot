package test.sample.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.sample.dao.MyPotDAO;
import test.sample.model.Clip;
import test.sample.model.Favorite;

@Service("myPotService")
@Transactional
public class MyPotServiceImpl implements MyPotService {
	
	@Resource(name="myPotDAO")
	private MyPotDAO myPotDAO;
	
	@Override
	public void addClipToMyPot (Favorite favorite) throws Exception {
		myPotDAO.addClipToMyPot(favorite);
	}
	@Override
	public List<Map<String, Clip>> showMyPot (String userId) throws Exception{
		return myPotDAO.showMyPot(userId);
	}
	@Override
	public void delAllClips(String userId) throws Exception {
		myPotDAO.delAllClips(userId);
	}
	@Override
	public int checkExistenceOfFavorite(Favorite favorite) throws Exception {
		return myPotDAO.checkExistenceOfFavorite(favorite);
	}
}
