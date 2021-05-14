package naver.cloud;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NaverController {
	
	@Autowired
	NaverFaceService service;
	@Autowired
	NaverFaceService2 service2;
	@Autowired
	NaverOCRService ocrservice;
	@Autowired
	NaverObjectDetectionService objectdetectionservice;
	@Autowired
	NaverPoseService poseservice;
	@Autowired
	NaverSpeechService speechservice;
	@Autowired
	NaverVoiceService voiceservice;
	
	
	
	@RequestMapping("/faceinput")
	public ModelAndView faceinput() {
		ModelAndView mv = new ModelAndView();
		
		File f = new File("/Users/melonbottle/images");
		String[] filelist = f.list();
		
		mv.addObject("filelist", filelist);
		mv.setViewName("/naver/faceinput");
		
		return mv;
	}
	
	@RequestMapping(value = "/face", method = RequestMethod.GET)
	public ModelAndView face(String image) {
		String result = service.test(image); // 유명인 닮은 꼴
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("faceResult", result);
		mv.setViewName("/naver/face");
		
		return mv;
	}
	
	@RequestMapping("/faceinput2")
	public ModelAndView faceinput2() {
		ModelAndView mv = new ModelAndView();
		
		File f = new File("/Users/melonbottle/images");
		String[] filelist = f.list();
		
		mv.addObject("filelist", filelist);
		mv.setViewName("/naver/faceinput2");
		
		return mv;
	}
	
	@RequestMapping(value = "/face2", method = RequestMethod.GET)
	public ModelAndView face2(String image) {
		String result = service2.test(image); // 얼굴 인식 서비스 결과
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("faceResult2", result);
		mv.setViewName("/naver/face3");
		
		return mv;
	}
	
	@RequestMapping("/ocrinput")
	public ModelAndView ocrinput() {
		ModelAndView mv = new ModelAndView();
		
		File f = new File("/Users/melonbottle/images");
		String[] filelist = f.list();
		
		mv.addObject("filelist", filelist);
		mv.setViewName("/naver/ocrinput");
		
		return mv;
	}
	
	@RequestMapping(value = "/ocr", method = RequestMethod.GET)
	public ModelAndView ocr(String image) {
		String result = ocrservice.test(image); // OCR 서비스 결과
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("ocrResult", result);
		mv.setViewName("/naver/ocr");
		
		return mv;
	}
	
	@RequestMapping("/objectdetectioninput")
	public ModelAndView objectdetectioninput() {
		ModelAndView mv = new ModelAndView();
		
		File f = new File("/Users/melonbottle/images");
		String[] filelist = f.list();
		
		mv.addObject("filelist", filelist);
		mv.setViewName("/naver/objectdetectioninput");
		
		return mv;
	}
	
	@RequestMapping(value = "/objectdetection", method = RequestMethod.GET)
	public ModelAndView objectdetection(String image) {
		String result = objectdetectionservice.test(image); // OCR 서비스 결과
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("objectdetectionResult", result);
		mv.setViewName("/naver/objectdetection");
		
		return mv;
	}
	
	@RequestMapping("/poseinput")
	public ModelAndView poseinput() {
		ModelAndView mv = new ModelAndView();
		
		File f = new File("/Users/melonbottle/images");
		String[] filelist = f.list();
		
		mv.addObject("filelist", filelist);
		mv.setViewName("/naver/poseinput");
		
		return mv;
	}
	
	@RequestMapping(value = "/pose", method = RequestMethod.GET)
	public ModelAndView pose(String image) {
		String result = poseservice.test(image); // 서비스 결과
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("poseResult", result);
		mv.setViewName("/naver/pose");
		
		return mv;
	}
	
	@RequestMapping("/speechinput")
	public ModelAndView speechinput() {
		ModelAndView mv = new ModelAndView();
		
		File f = new File("/Users/melonbottle/images");
		String[] filelist = f.list();
		
		mv.addObject("filelist", filelist);
		mv.setViewName("/naver/speechinput");
		
		return mv;
	}
	
	@RequestMapping(value = "/speech", method = RequestMethod.GET)
	public ModelAndView speech(String image, String lang) {
		String result = "";
		if(lang == null) {
			result = speechservice.test(image); // 서비스 결과
		}
		else {
			result = speechservice.test(image, lang); // 서비스 결과
		}
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("speechResult", result);
		mv.setViewName("/naver/speech");
		
		return mv;
	}
	
	@RequestMapping("/voiceinput")
	public ModelAndView voiceinput() {
		ModelAndView mv = new ModelAndView();
		
		File f = new File("/Users/melonbottle/images");
		String[] filelist = f.list();
		
		mv.addObject("filelist", filelist);
		mv.setViewName("/naver/voiceinput");
		
		return mv;
	}
	
	@RequestMapping(value = "/voice", method = RequestMethod.GET)
	public ModelAndView voice(String image, String speaker) {
		String result = "";
		if (speaker==null) {
			result = voiceservice.test(image); // 서비스 결과
		}
		else {
			result = voiceservice.test(image, speaker); // 서비스 결과
		}
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("voiceResult", result);
		mv.setViewName("/naver/voice");
		
		return mv;
	}
	
}
