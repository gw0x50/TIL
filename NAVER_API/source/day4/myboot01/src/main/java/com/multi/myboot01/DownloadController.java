package com.multi.myboot01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DownloadController {
	
	@RequestMapping("/filedownload")
	public ModelAndView downloadform() {
		ModelAndView mv = new ModelAndView();
		File path = new File("/Users/melonbottle/upload/");
		String [] filelist = path.list();
		mv.addObject("details", filelist);
		mv.setViewName("upload/downloadform");
		
		return mv;
	}
	
	@RequestMapping("/downloadresult")
	public void downloadresult(HttpServletResponse response, String file) throws IOException {
		File f = new File("/Users/melonbottle/upload/", file);
		
		// 파일 다운로드를 응답하겠다고 선언, 파일명, 길이 포함
		response.setContentType("application/download");
		response.setContentLength((int)f.length());
		response.setHeader("Content-Disposition", "attachment;filename=\""+file+"\"");
		
		// 파일명에 해당하는 파일을 읽어서 클라이언트에서 복사, 출력
		OutputStream out = response.getOutputStream();
		FileInputStream fin = new FileInputStream(f);
		FileCopyUtils.copy(fin, out);
		fin.close();
		out.close();
	}
}
