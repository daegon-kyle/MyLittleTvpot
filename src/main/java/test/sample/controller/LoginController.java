package test.sample.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import test.sample.model.User;
import test.sample.service.LoginService;

@Controller
public class LoginController {
	@Resource(name="loginService")
	private LoginService loginService;
	
	@RequestMapping(value="/login.do")
	public @ResponseBody ModelAndView openLoginPage() throws Exception {
		ModelAndView mv = new ModelAndView("/login");
				
		return mv;
	}
	@RequestMapping(value="logout.do")
	public @ResponseBody void logout(HttpSession session) throws Exception {
		session.removeAttribute("userId");
	}
	@RequestMapping(value="/checkSession.do")
	public @ResponseBody Object checkSession(HttpSession session) throws Exception {
		boolean isSuccess;
		
		if (session.getAttribute("userId") == null) {
			isSuccess = false;
		}
		else {
			isSuccess = true;
		}
		
		return isSuccess;
	}
	@RequestMapping(value="/loginToClipList.do", produces="application/json;charset=UTF-8")
	public @ResponseBody Boolean loginToClipList(HttpSession session, @RequestParam("userId") String userId, @RequestParam("userNickname") String userNickname, @RequestParam("profile_image") String profile_image) throws Exception {
		session.setAttribute("userId", userId);
		User user;
		
		boolean isSuccess = loginService.checkAvailId(userId);
		
		if (isSuccess) {
			user = new User(userId, userNickname, profile_image);
			loginService.saveUserInfo(user);
		}
		
		return Boolean.valueOf(isSuccess);
	}
	@RequestMapping(value="/loginByDiffAddress.do", method=RequestMethod.GET)
	public @ResponseBody ModelAndView openLoginByDiffAddress(@RequestParam("url") String url) throws Exception {
		ModelAndView mv = new ModelAndView("/login");

		mv.addObject("url", url);
		
		return mv;
	}
}