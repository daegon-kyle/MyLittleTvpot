package test.sample.service;

import java.util.List;
import java.util.Map;

import test.sample.model.Clip;
import test.sample.model.Favorite;

public interface MyPotService {
	public void addClipToMyPot(Favorite favorite) throws Exception;
	public List<Map<String, Clip>> showMyPot(String userId) throws Exception;
	public void delAllClips(String userId) throws Exception;
	public int checkExistenceOfFavorite(Favorite favorite) throws Exception;
}
