package com.keduit.project02.domain;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Setter
@Getter
public class CartVO {
	
	private long cno;
	private String themeName;
	private String dogSize;
	private String pictureSize;
	private int people;
	private String bookingdatetime;
	private String bType;
	private int price;
	
	
/*	
	bookingdatetime datetime ,
	themeName varchar(8),
	price int */

}
