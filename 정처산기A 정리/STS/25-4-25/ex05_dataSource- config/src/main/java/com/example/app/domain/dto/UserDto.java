package com.example.app.domain.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	@Size(min=1,max=10, message="아이디의 글자수는 1개에서 10개까지만 됩니다.")
	@NotBlank(message="id 를 입력하세요")
	private String userid;		//유저ID
	@NotBlank(message="password 를 입력하세요")
	@Pattern(regexp = "[^!#$%]",message="!,#,$,% 는 쓸 수 없습니다" )
	private String password;	//패스워드
	@NotBlank(message="rePassword 를 입력하세요")
	private String rePassword;	//패스워드확인
	@NotBlank(message="username 를 입력하세요")
	@Size(min=1,max=8, message="아이디의 글자수는 1개에서 8개까지만 됩니다.")	
	private String username;	//유저이름
	@NotBlank(message="phone 를 입력하세요")
	private String phone;		//전화번호
	@NotBlank(message="zipcode 를 입력하세요")
	private String zipcode;		//우편번호
	@NotBlank(message="addr1 를 입력하세요")
	private String addr1;		//기본주소
	@NotBlank(message="addr2 를 입력하세요")
	private String addr2;		//상세주소
	
	@NotNull(message="birthday 를 입력하세요")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate birthday;	//생년월일(yyyy-MM-dd)
}