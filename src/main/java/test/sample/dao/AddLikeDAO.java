package test.sample.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import test.common.dao.AbstractDAO;

@Repository("addLikeDAO")
public class AddLikeDAO extends AbstractDAO{
	
	public boolean updateClip(String clipId, String userId) {
		HashMap<String, String> likeInfo = new HashMap<String, String>();
		likeInfo.put("clipId", clipId);
		likeInfo.put("userId", userId);
		
		boolean isSuccess = selectOne("checkLike", likeInfo).equals(new Integer(1));
		if (isSuccess) {
			return false;
		}
		else{
			update("addLike", clipId);
			insert("addUserClip", likeInfo);
			return true;
		}
	}
}
