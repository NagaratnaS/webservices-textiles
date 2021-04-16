package com.wolken.wolkenapp.dao;

import java.util.List;

import com.wolken.wolkenapp.entity.TextileEntity;

public interface TextilesDAO {
	public String add(TextileEntity entity);
	public TextileEntity getByID(int textileShopID);
	public int updateByID(TextileEntity entity);
	public List<TextileEntity> getAll();
	public int deleteByID(int textileShopID);

}
