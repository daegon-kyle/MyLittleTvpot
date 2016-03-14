package test.sample.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.sample.dao.AddLikeDAO;

@Service("addLikeService")
@Transactional
public class AddLikeServiceImpl implements AddLikeService {

	@Resource(name="addLikeDAO")
	private AddLikeDAO addLikeDAO;
	
	@Override
	public boolean addLike(String clipId, String userId) throws Exception {
		boolean isSuccess = addLikeDAO.updateClip(clipId, userId);
		if (isSuccess)
			return true;
		else
			return false;
	}
	
}
