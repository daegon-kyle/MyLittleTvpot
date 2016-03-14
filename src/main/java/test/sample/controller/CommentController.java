package test.sample.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import test.sample.model.Comment;
import test.sample.model.User;
import test.sample.service.CommentService;
import test.sample.service.UserService;

@Controller
public class CommentController {
	@Resource(name="commentService")
	private CommentService commentService;
	
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping(value="/regiComment.do", produces="application/json;charset=UTF-8", method=RequestMethod.POST)
	public @ResponseBody Object regiComment(@RequestParam("clipId") String clipId, @RequestParam("comment") String comment, HttpSession session) throws Exception {
		String userId = (String)session.getAttribute("userId");
		User user = userService.getUserInfo(userId);
		Date serverTime = new Date(System.currentTimeMillis());
		Comment newComment;
		
		newComment = new Comment(clipId, userId, user.getNickname(), user.getProfile_image(), comment, serverTime);
		
		Comment successfulComment= commentService.regiComment(newComment);
		
		return successfulComment;
	}
	@RequestMapping(value="/delComment.do", produces="application/json;charset=UTF-8", method=RequestMethod.POST)
	public @ResponseBody Object delComment(@RequestParam("delCommentId") String delCommentId, @RequestParam("clipId") String clipId,HttpSession session) throws Exception {
		boolean isSuccess;
		
		if (session.getAttribute("userId") == null) {
			isSuccess = false;
		}
		else {
			String currentUserId = (String)session.getAttribute("userId");
			String realCommentOwnerId = commentService.getRealCommentOwnerId(delCommentId);
			
			if (currentUserId.equals(realCommentOwnerId)) {
				commentService.delComment(delCommentId);
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		
		return Boolean.valueOf(isSuccess);
	}
}
