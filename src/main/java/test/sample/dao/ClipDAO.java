package test.sample.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import test.common.dao.AbstractDAO;
import test.sample.model.Clip;

@Repository("clipDAO")
public class ClipDAO extends AbstractDAO{
	
	public Clip getClip(String clipId) {
		return (Clip)selectOne("selectOneClip", clipId);
	}
	@SuppressWarnings("unchecked")
	public List<Map<String, Clip>> moreClipsList(int firstClipId) {
		return (List<Map<String, Clip>>)selectList("moreClipsList", firstClipId);
	}
	@SuppressWarnings("unchecked")
	public List<Map<String, Clip>> moreClipsInClipViewList(int firstClipId) {
		return (List<Map<String, Clip>>)selectList("moreClipsInClipViewList", firstClipId);
	}
	public void addNumOfPlay(Map<String, String> playInfoMap) {
		update("addNumOfPlay", playInfoMap);
	}
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectClipList() {
		return (List<Map<String, Object>>)selectList("selectClipList");
	}
}