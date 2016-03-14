package test.sample.service;

import java.util.List;
import java.util.Map;

import test.sample.model.Comment;

public interface CommentService {
	List<Map<String, Comment>> selectCommentList(String clipId) throws Exception;
	Comment regiComment(Comment newComment) throws Exception;
	void delComment(String delCommentId) throws Exception;
	String getRealCommentOwnerId(String delCommentId) throws Exception;
}