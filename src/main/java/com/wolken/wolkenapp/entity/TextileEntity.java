package com.wolken.wolkenapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity
@Table(name = "textile")
public class TextileEntity {
	@Id
	@Column(name = "textileShopID")
	private int textileShopID;
	@Column(name = "textileShopName")
	private String textileShopName;
	@Column(name = "location")
	private String location;
	@Column(name = "noOfFloors")
	private int noOfFloors;


}
