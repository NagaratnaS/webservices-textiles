package com.wolken.wolkenapp.dao;

import com.wolken.wolkenapp.entity.TextileEntity;

public interface TextilesDAO {
	public String add(TextileEntity entity);
	public TextileEntity getByID(int textileShopID);
	public int updateByID(TextileEntity entity);

}
