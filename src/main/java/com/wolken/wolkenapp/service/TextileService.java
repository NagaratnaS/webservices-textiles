package com.wolken.wolkenapp.service;

import com.wolken.wolkenapp.dto.TextileDTO;

public interface TextileService {
	public String validateAndAdd(TextileDTO dto);
	public TextileDTO validateAndGet(int textileShopID);
	public String validateAndUpdateByID(TextileDTO dto);

}
