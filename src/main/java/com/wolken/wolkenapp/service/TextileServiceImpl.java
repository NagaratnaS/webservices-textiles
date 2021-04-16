package com.wolken.wolkenapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wolken.wolkenapp.dao.TextilesDAO;
import com.wolken.wolkenapp.dto.TextileDTO;
import com.wolken.wolkenapp.entity.TextileEntity;

@Service
public class TextileServiceImpl implements TextileService{
	
	@Autowired
	TextilesDAO dao;
	@Autowired
	TextileEntity entity;

	@Override
	public String validateAndAdd(TextileDTO dto) {
		// TODO Auto-generated method stub
		String message = null;
		if(dto != null) {
			if(dto.getTextileShopID() > 0 && !dto.getTextileShopName().equals(null) && !dto.getLocation().equals(null) && dto.getNoOfFloors() > 0) {
				entity.setTextileShopID(dto.getTextileShopID());
				entity.setTextileShopName(dto.getTextileShopName());
				entity.setLocation(dto.getLocation());
				entity.setNoOfFloors(dto.getNoOfFloors());
				message = dao.add(entity);
			}
		}
		return message;
	}
	

}
