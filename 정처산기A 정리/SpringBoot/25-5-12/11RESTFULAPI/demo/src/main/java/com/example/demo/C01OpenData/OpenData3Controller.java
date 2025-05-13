package com.example.demo.C01OpenData;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URLEncoder;

@RestController
@Slf4j
@RequestMapping("/openData")
public class OpenData3Controller {

    String url = "https://apisdata.go.kr/1400377/forestPoint/forestPointListGeongugSearch";
    String serviceKey = "YNOMoFS2U6pQGBjkLvvcg+yA5jPisDigd02vYyadWECrYaeU+9BK9k0R5fV0tcEVpmiTVsJrgp5VThzsia9Ckg==";
    String pageNo = "1";
    String numOfRows = "10";
    String _type = "JSON";
    String excludeForecast = "0";

   @GetMapping("/forest")
    public void forest() throws Exception{
       log.info("GET /openData/forest...");

       //서버 정보
//       url +="?serviceKey=" + serviceKey;
//       url +="&pageNo=" + pageNo;
//       url +="&numOfRows=" + numOfRows;
//       url +="&_type=" + _type;
//       url +="&excludeForecast=" + excludeForecast;

       UriComponentsBuilder uri = UriComponentsBuilder
               .fromHttpUrl(url)
               .queryParam("serviceKey", URLEncoder.encode(serviceKey, "UTF-8"))
               .queryParam("pageNo=" , pageNo)
               .queryParam("numOfRows=" , numOfRows)
               .queryParam("_type=" , _type)
               .queryParam("excludeForecast=" , excludeForecast);
//               .build(true);

       //요청-> 응답
       RestTemplate rt = new RestTemplate();
       ResponseEntity<String> response = rt.exchange(url, HttpMethod.GET, null, String.class);
       System.out.println(response.getBody());

   }




}

