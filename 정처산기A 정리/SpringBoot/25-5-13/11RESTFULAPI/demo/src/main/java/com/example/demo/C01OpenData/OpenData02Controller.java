package com.example.demo.C01OpenData;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/openData")
public class OpenData02Controller {

    String url = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst";
    String serviceKey = "xYZ80mMcU8S57mCCY/q8sRsk7o7G8NtnfnK7mVEuVxdtozrl0skuhvNf34epviHrru/jiRQ41FokE9H4lK0Hhg==";
    String pageNo = "1";
    String numOfRows = "10";
    String base_date = "20250509";
    String base_time = "1600";
    String dataType = "JSON";
    String nx = "89";
    String ny = "90";

   @GetMapping("/forcast")
    public void forcast(){
       log.info("GET /openData/forcast...");

       //서버 정보
       url +="?serviceKey=" + serviceKey;
       url +="&pageNo=" + pageNo;
       url +="&numOfRows=" + numOfRows;
       url +="&base_date=" + base_date;
       url +="&base_time=" + base_time;
       url += "&dataType=" + dataType;
       url +="&nx=" + nx;
       url +="&ny=" + ny;

       //요청 헤더


       //요청 바디


       //요청-> 응답
       RestTemplate rt = new RestTemplate();
       ResponseEntity<Root> response = rt.exchange(url, HttpMethod.GET, null, Root.class);
       System.out.println(response.getBody());

       //데이터 가공처리
       Root root = response.getBody();
       Response rs = root.getResponse();
       Body body = rs.getBody();
       Items items = body.getItems();
       List<Item> list = items.getItem();
       list.stream().forEach(System.out::println);
   }
    // import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
    @Data
    private static class Body{
        public String dataType;
        public Items items;
        public int pageNo;
        public int numOfRows;
        public int totalCount;
    }
    @Data
    private static class Header{
        public String resultCode;
        public String resultMsg;
    }
    @Data
    private static class Item{
        public String baseDate;
        public String baseTime;
        public String category;
        public int nx;
        public int ny;
        public String obsrValue;
    }
    @Data
    private static class Items{
        public ArrayList<Item> item;
    }
    @Data
    private static class Response{
        public Header header;
        public Body body;
    }
    @Data
    private static class Root{
        public Response response;
    }



}

