package test.sample.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import test.common.dao.AbstractDAO;
import test.sample.model.Comment;

@Repository("commentDAO")
public class CommentDAO extends AbstractDAO {
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Comment>> selectCommentList(String clipId) {
		return (List<Map<String, Comment>>)selectList("commentList", clipId);
	}
	public Comment regiComment(Comment newComment) {
		insert("registerComment", newComment);
		
		return (Comment)selectOne("commentAfterRegi", newComment);
	}
	public void delComment(String delCommentId) {
		update("changeAvailOfComment", delCommentId);
	}
	
	public String getRealCommentOwnerId(String delCommentId) {
		return (String)selectOne("getRealCommentOwnerId", delCommentId);
	}
}