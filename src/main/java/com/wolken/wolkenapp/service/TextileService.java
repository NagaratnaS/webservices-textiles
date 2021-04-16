package com.wolken.wolkenapp.service;

import java.util.List;

import com.wolken.wolkenapp.dto.TextileDTO;

public interface TextileService {
	public String validateAndAdd(TextileDTO dto);
	public TextileDTO validateAndGet(int textileShopID);
	public String validateAndUpdateByID(TextileDTO dto);
	public List<TextileDTO> validateAndGetAll();
	public String validateAndDelete(int textileShopID);

}
