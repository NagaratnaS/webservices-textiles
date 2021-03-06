package com.wolken.wolkenapp.service;

import java.util.ArrayList;
import java.util.List;

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
	@Autowired
	TextileDTO dto;

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

	@Override
	public TextileDTO validateAndGet(int textileShopID) {
		// TODO Auto-generated method stub
		if(textileShopID > 0) {
			entity = dao.getByID(textileShopID);
			dto.setTextileShopID(entity.getTextileShopID());
			dto.setTextileShopName(entity.getTextileShopName());
			dto.setLocation(entity.getLocation());
			dto.setNoOfFloors(entity.getNoOfFloors());
		}
		return dto;
	}

	@Override
	public String validateAndUpdateByID(TextileDTO dto) {
		// TODO Auto-generated method stub
		if(dto != null) {
			if(dto.getTextileShopID() > 0 && !dto.getTextileShopName().equals(null) && !dto.getLocation().equals(null) && dto.getNoOfFloors() > 0) {
				entity.setTextileShopID(dto.getTextileShopID());
				entity.setTextileShopName(dto.getTextileShopName());
				entity.setLocation(dto.getLocation());
				entity.setNoOfFloors(dto.getNoOfFloors());
				int result = dao.updateByID(entity);
				if(result > 0) {
					return "Successfully updated!!";
				}
				
			}
			
		}
		return "Not updated , some error occured";
	}

	@Override
	public List<TextileDTO> validateAndGetAll() {
		// TODO Auto-generated method stub
		List<TextileEntity> entityList = dao.getAll();
		List<TextileDTO> dtoList = new ArrayList<TextileDTO>();;
		for(TextileEntity tempEntity: entityList) {
			dto = new TextileDTO();
			dto.setTextileShopID(tempEntity.getTextileShopID());
			dto.setTextileShopName(tempEntity.getTextileShopName());
			dto.setLocation(tempEntity.getLocation());
			dto.setNoOfFloors(tempEntity.getNoOfFloors());
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public String validateAndDelete(int textileShopID) {
		// TODO Auto-generated method stub
		if(textileShopID > 0) {
			int result = dao.deleteByID(textileShopID);
			if (result > 0) 
				return "Deleted successfully!!";
		}
		return "Some error occurred!!";
	}
	

}
