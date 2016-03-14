package test.sample.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import test.common.dao.AbstractDAO;
import test.sample.model.Clip;
import test.sample.model.Favorite;

@Repository("myPotDAO")
public class MyPotDAO extends AbstractDAO {
	public void addClipToMyPot (Favorite favorite) {
		insert("addClipToMyPot", favorite);
	}
	@SuppressWarnings("unchecked")
	public List<Map<String, Clip>> showMyPot(String userId) {
		List<Map<String, Clip>> myPotClipList = selectList("showMyPotInfo", userId);
		
		return myPotClipList;
	}
	public void delAllClips (String userId) {
		delete("delAllClips", userId);
	}
	public int checkExistenceOfFavorite (Favorite favorite) {
		return (Integer)selectOne("checkExistenceOfFavorite", favorite);
	}
}
