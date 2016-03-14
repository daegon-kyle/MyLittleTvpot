package test.sample.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.sample.dao.ClipDAO;
import test.sample.model.Clip;

@Service("clipService")
@Transactional
public class ClipServiceImpl implements ClipService{
	@Resource(name="clipDAO")
	private ClipDAO clipDAO;

	public Clip getClip(String clipId) throws Exception {
		return clipDAO.getClip(clipId);
	}
	public List<Map<String, Clip>> moreClipsList(int firstClipId) throws Exception {
		return clipDAO.moreClipsList(firstClipId);
	}
	public List<Map<String, Clip>> moreClipsInClipViewList(int firstClipId) throws Exception {
		return clipDAO.moreClipsInClipViewList(firstClipId);
	}
	public void addNumOfPlay(Map<String, String> playInfoMap) throws Exception {
		clipDAO.addNumOfPlay(playInfoMap);
	}
	public List<Map<String, Object>> selectClipList() throws Exception {
		return clipDAO.selectClipList();
	}
}
