package test.sample.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import test.sample.service.AddLikeService;

@Controller
public class AddLikeController {
	public static final int SERVER_ERROR = 400;
	
	@Resource(name="addLikeService")
	private AddLikeService addLikeService;
	
	@RequestMapping(value="/addLike.do", method=RequestMethod.POST)
	public void addLike(@RequestParam("clipId") String clipId, HttpServletResponse response, HttpSession session) throws Exception {
		boolean isSuccess = addLikeService.addLike(clipId, (String)session.getAttribute("userId"));
		
		if (!(isSuccess)) {
			response.sendError(SERVER_ERROR);
		}
	}	
	
}
