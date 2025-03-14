package c19;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class c13Ex {

	public static void main(String[] args) throws Exception {
		//API 선택해서 받아오기
		
		//URL, PARAM 지정
		String url = "https://api.openweathermap.org/data/3.0/onecall";
		String mode = "";
		String addr = "";
		url = url+"?mode"+mode+"&addr"+addr;
		
		//Request 객체 생성
		HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
		
		//요청, 응답
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		
		//가공처리
		ObjectMapper objectMapper = new ObjectMapper();
		
		ResponseObject responseObject = objectMapper.readValue(response.body(), ResponseObject.class);
		Syso
		

	}

}
