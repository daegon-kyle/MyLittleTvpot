package test.sample.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import test.sample.model.Clip;
import test.sample.service.ClipService;

@Controller
public class MoreClipsController {
	@Resource(name="clipService")
	private ClipService clipService;
	
	@RequestMapping(value="moreClips.do", produces="application/json;charset=UTF-8", method=RequestMethod.POST)
	public @ResponseBody Object moreClips(@RequestParam("firstClipId") int firstClipId) throws Exception {
		List<Map<String, Clip>> clipList = clipService.moreClipsList(firstClipId);
		
		return clipList;
	}
	@RequestMapping(value="moreClipsInClipView.do", produces="application/json;charset=UTF-8", method=RequestMethod.POST)
	public @ResponseBody Object moreClipsInClipView(@RequestParam("firstClipId") int firstClipId) throws Exception {
		List<Map<String, Clip>> clipList = clipService.moreClipsInClipViewList(firstClipId);
		
		return clipList;
	}
}
