package com.example.app.domain.dto;

import org.springframework.web.multipart.MultipartFile;

public class FileDto {
	private long id;
	private String category;
	private int price;
	private MultipartFile [] files;

}
