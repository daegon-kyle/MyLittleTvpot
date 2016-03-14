package test.sample.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import test.sample.model.Favorite;
import test.sample.service.MyPotService;

@Controller
public class ClipInMyPotController {
	public static final int SERVER_ERROR = 400;
	
	@Resource(name="myPotService")
	private MyPotService myPotService;
	
	@RequestMapping(value="/delAllClips.do")
	public @ResponseBody ModelAndView delAllClipsInMyPot(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView("myPot");
		String userId = (String)session.getAttribute("userId");
		
		myPotService.delAllClips(userId);
		
		return mv;
	}
	@RequestMapping(value="/addClipToMyPot.do", method=RequestMethod.POST)
	public @ResponseBody void addClipToMyPot(HttpSession session, HttpServletResponse response, @RequestParam("clipId") String clipId) throws Exception {
		String userId = (String)session.getAttribute("userId");
		Favorite favorite = new Favorite(userId, clipId);
		boolean isExistentInMyPot = false;
		
		if (myPotService.checkExistenceOfFavorite(favorite) > 0) {
			isExistentInMyPot = true;
		};
		
		myPotService.addClipToMyPot(favorite);
		
		if (isExistentInMyPot) {
			response.sendError(SERVER_ERROR);
		}
	}
}
