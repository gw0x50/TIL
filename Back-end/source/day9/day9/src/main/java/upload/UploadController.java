package upload;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	public static String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
	}

	@RequestMapping(value = "/fileupload", method = RequestMethod.GET)
	public String uploadform() {
		return "/upload/uploadform";
	}

	@RequestMapping(value = "/fileupload", method = RequestMethod.POST)
	public String uploadresult(@ModelAttribute("vo") UploadVO vo) throws IOException {

		MultipartFile multipartfile1 = vo.getFile1();
		MultipartFile multipartfile2 = vo.getFile2();

		String filename1 = multipartfile1.getOriginalFilename();
		String filename2 = multipartfile2.getOriginalFilename();

		System.out.println(filename1 + " / " + filename2);

		String savePath = "/Users/melonbottle/upload/";

		// 중복파일처리1 : 
		// api : 랜덤암호화변경이름
		// a.txt --> 123wsdjhfckdjf.txt
		String ext1 = filename1.substring(filename1.lastIndexOf("."));
		String ext2 = filename2.substring(filename2.lastIndexOf("."));

		System.out.println(ext1 + ":" + ext2);
		String saveFileName1 = getUuid() + ext1;
		String saveFileName2 = getUuid() + ext2;

		File file1 = new File(savePath + saveFileName1);
		File file2 = new File(savePath + saveFileName2);

		multipartfile1.transferTo(file1);
		multipartfile2.transferTo(file2);

		return "/upload/uploadresult";
	}
}
