package test.sample.service;

import java.util.List;
import java.util.Map;

import test.sample.model.Clip;

public interface ClipService {
	Clip getClip(String id) throws Exception;
	List<Map<String, Clip>> moreClipsList(int firstClipId) throws Exception;
	List<Map<String, Clip>> moreClipsInClipViewList(int firstClipId) throws Exception;
	void addNumOfPlay(Map<String, String> playInfoMap) throws Exception;
	List<Map<String, Object>> selectClipList() throws Exception;
}
