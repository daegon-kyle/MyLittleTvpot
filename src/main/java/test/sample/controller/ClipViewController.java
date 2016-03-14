package test.sample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import test.sample.model.Clip;
import test.sample.model.Comment;
import test.sample.model.Favorite;
import test.sample.model.User;
import test.sample.service.ClipService;
import test.sample.service.CommentService;
import test.sample.service.MyPotService;
import test.sample.service.UserService;

@Controller
public class ClipViewController {
	@Resource(name="clipService")
	private ClipService clipService;

	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="commentService")
	private CommentService commentService;
	
	@Resource(name="myPotService")
	private MyPotService myPotService;
	
	@RequestMapping(value="/openClipList.do")
	public ModelAndView openClipList(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView("/firstPage");
		
		List<Map<String, Object>> clipList = clipService.selectClipList();
		
		String userId = (String) session.getAttribute("userId");
		
		if (userService.getUserInfo(userId) != null) {
			User currentUser = userService.getUserInfo(userId);
			String userNickname = currentUser.getNickname();
			mv.addObject("userNickname", userNickname);
		}
		
		mv.addObject("clipList", clipList);
		
		return mv;
	}
	@RequestMapping(value="/clipView.do", method=RequestMethod.GET )
	public @ResponseBody ModelAndView openClip(HttpSession session, @RequestParam("clipId") String clipId) throws Exception {
		ModelAndView mv = new ModelAndView("/clipView");
		
		List<Map<String, Object>> clipList = clipService.selectClipList();
		Clip clip = clipService.getClip(clipId);
		List<Map<String, Comment>> commentList = commentService.selectCommentList(clipId);		
		String userId = (String)session.getAttribute("userId");
		
		if (userService.getUserInfo(userId) != null) {
			User currentUser = userService.getUserInfo(userId);
			String userNickname = currentUser.getNickname();
			boolean isExistentInMyPot = false;
			
			Favorite favorite = new Favorite(userId, clipId);
			if (myPotService.checkExistenceOfFavorite(favorite) > 0) {
				isExistentInMyPot = true;
			}
			
			mv.addObject("isExistentInMyPot", isExistentInMyPot);
			mv.addObject("userNickname", userNickname);
			mv.addObject("userId", userId);
		}
		
		mv.addObject("clipList", clipList);
		mv.addObject("clip", clip);
		mv.addObject("commentList", commentList);
		
		return mv;
	}
	@RequestMapping(value="/showMyPot.do")
	public @ResponseBody ModelAndView showMyPot(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView("myPot");
		String userId = (String)session.getAttribute("userId");
		
		List<Map<String, Clip>> clipList = myPotService.showMyPot(userId);
		User currentUser = userService.getUserInfo(userId);
		String userNickname = currentUser.getNickname();
		
		mv.addObject("userNickname", userNickname);
		mv.addObject("clipList", clipList);
		
		return mv;
	}
	@RequestMapping(value="addNumOfPlay.do", method=RequestMethod.POST)
	public @ResponseBody void addNumOfPlay(@RequestParam("clipId") String clipId, @RequestParam("numOfPlay") String numOfPlay) throws Exception {
		Map<String, String> playInfoMap = new HashMap<String, String>();
		
		playInfoMap.put("clipId", clipId);
		playInfoMap.put("numOfPlay", numOfPlay);

		clipService.addNumOfPlay(playInfoMap);
	}
}
