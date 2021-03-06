package naver.cloud;

// 네이버 음성합성 Open API 예제
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class NaverVoiceService implements NaverService{
	public String test(String txtfile) {
		return test(txtfile, "mijin");
	}
	public String test(String txtfile, String speaker) {
		String returnfile = null;

		try {
			String text = URLEncoder.encode("만나서 반갑습니다.", "UTF-8"); // 13자
			text = "";

			FileReader fr = new FileReader("/Users/melonbottle/images/" + txtfile);
			BufferedReader inputbr = new BufferedReader(fr);
			while (true) {
				String line = inputbr.readLine();
				if (line == null) break;
				text += line + "\n";
			}
			System.out.println(text);
			text = URLEncoder.encode(text, "UTF-8");
			System.out.println(text);

			String apiURL = "https://naveropenapi.apigw.ntruss.com/tts-premium/v1/tts";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
			con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
			// post request
			String postParams = "speaker=" + speaker + "&volume=0&speed=0&pitch=0&format=mp3&text=" + text;
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(postParams);
			wr.flush();
			wr.close();
			int responseCode = con.getResponseCode();
			BufferedReader br;
			System.out.println(responseCode);
			if (responseCode == 200) { // 정상 호출
				InputStream is = con.getInputStream();
				int read = 0;
				byte[] bytes = new byte[1024];
				// 랜덤한 이름으로 mp3 파일 생성
				String tempname = Long.valueOf(new Date().getTime()).toString();
				File f = new File("/Users/melonbottle/images/" + tempname + ".mp3");
				returnfile = tempname + ".mp3";
				f.createNewFile();
				OutputStream outputStream = new FileOutputStream(f);
				while ((read = is.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}
				is.close();
			}
			else { // 오류 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = br.readLine()) != null) {
					response.append(inputLine);
				}
				br.close();
				System.out.println(response.toString());
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return returnfile;
	}

}
