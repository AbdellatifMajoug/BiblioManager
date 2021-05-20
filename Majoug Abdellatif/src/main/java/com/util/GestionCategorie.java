package com.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestionCategorie {
	
	public int AddCategorie(String name) 
	{
		DBinteraction.connect();
		String sql = "insert into categorie(name) values ('"+name+"')";
		int nb = DBinteraction.Maj(sql);
		DBinteraction.disconnect();
		return nb;
	}
	public int findCategorieByname(String cat) 
	{
		Categorie c = new Categorie();
		DBinteraction.connect();
		String sql = "select * from categorie where name='"+cat+"'";
		ResultSet rs = DBinteraction.select(sql);
		try {
			if(rs.next())
			{
				c = new Categorie();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c.getId();
	}
    public List<Categorie> allCategories()
    {
    	List<Categorie> c= new ArrayList<Categorie>();
    	DBinteraction.connect();
    	String sql = "select * from categorie";
    	ResultSet rs = DBinteraction.select(sql);
    	try {
			while(rs.next())
			{
				Categorie cat = new Categorie();
				cat.setId(rs.getInt(1));
				cat.setName(rs.getString(2));
				//ajouter la categorie dans la liste
				c.add(cat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return c;
    }
    
    public Categorie findCategorieById(int id) 
	{
		Categorie c = new Categorie();
		DBinteraction.connect();
		String sql = "select * from categorie where id="+id;
		ResultSet rs = DBinteraction.select(sql);
		try {
			if(rs.next())
			{
				c = new Categorie();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
}