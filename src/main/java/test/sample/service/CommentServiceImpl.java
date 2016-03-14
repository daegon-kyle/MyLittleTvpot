package test.sample.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.sample.dao.CommentDAO;
import test.sample.model.Comment;

@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService{
	
	@Resource(name="commentDAO")
	private CommentDAO commentDAO;
	
	public List<Map<String, Comment>> selectCommentList(String clipId) throws Exception {
		return commentDAO.selectCommentList(clipId);
	}
	public Comment regiComment(Comment newComment) throws Exception {
		return commentDAO.regiComment(newComment);
	}
	public void delComment(String delCommentId) throws Exception {
		commentDAO.delComment(delCommentId);
	}
	public String getRealCommentOwnerId(String delCommentId) throws Exception {
		return commentDAO.getRealCommentOwnerId(delCommentId);
	}
}