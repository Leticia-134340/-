package com.example.demo.C02openWeatherMap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URLEncoder;

@RestController
@Slf4j
@RequestMapping("/open/weather")
public class OpenWeatherController {

    @GetMapping("/get")
    public void get(@PathVariable String lat, @PathVariable String lon) throws Exception{
        log.info("GET /open/weather/get...");
        String url="https://api.openweathermap.org/data/2.5/weather";
//        String lat="";
//        String lon="";
        String serviceKey="0ca869660f562829afd8c6d904621499";
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .queryParam("appid", URLEncoder.encode(serviceKey,"UTF-8"))
                .queryParam("lat",lat)
                .queryParam("lon", lon)
                .build(true)
                .toUri();


        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(uri, HttpMethod.GET, null, String.class);
        System.out.println(response);
    }
}
