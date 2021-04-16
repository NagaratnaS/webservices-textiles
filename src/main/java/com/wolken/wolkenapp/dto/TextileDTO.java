package com.wolken.wolkenapp.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Component
public class TextileDTO {
	private int textileShopID;
	private String textileShopName;
	private String location;
	private int noOfFloors;

}
