package com.wolken.wolkenapp.dao;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wolken.wolkenapp.entity.TextileEntity;

@Component
public class TextilesDAOImpl implements TextilesDAO{

	@Autowired
	TextileEntity entity;
	
	Configuration configuration = new Configuration();
	
	public TextilesDAOImpl() {
		configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/wolken");
		configuration.setProperty("hibernate.connection.username", "root");
		configuration.setProperty("hibernate.connection.password", "root");
		configuration.addAnnotatedClass(TextileEntity.class);
	}
	@Override
	public String add(TextileEntity entity) {
		// TODO Auto-generated method stub
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(entity);
		transaction.commit();
		session.close();
		return "data added successfully";
	}

	@Override
	public TextileEntity getByID(int textileShopID) {
		// TODO Auto-generated method stub
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from TextileEntity te where te.textileShopID = :textileShopID");
		query.setParameter("textileShopID", textileShopID);
		TextileEntity entity = (TextileEntity) query.uniqueResult();
		return entity;
	}

	@Override
	public int updateByID(TextileEntity entity) {
		// TODO Auto-generated method stub
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("update TextileEntity te set te.textileShopName = :textileShopName , te.location = :location , te.noOfFloors = :noOfFloors where te.textileShopID = :textileShopID");
		query.setParameter("textileShopID", entity.getTextileShopID());
		query.setParameter("textileShopName", entity.getTextileShopName());
		query.setParameter("location", entity.getLocation());
		query.setParameter("noOfFloors", entity.getNoOfFloors());
		
		int result = query.executeUpdate();
		transaction.commit();
		session.close();
		return result;
	}

}
