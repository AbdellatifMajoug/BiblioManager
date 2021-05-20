package com.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestionEtudiant {
	
	public int AddEtudiant(String log, String pass , String nom , String prenom) 
	{
		DBinteraction.connect();
		String sql = "insert into etudiant(log , pass , nom , prenom) values ('"+log+"','"+pass+"','"+nom+"','"+prenom+"')";
		int nb = DBinteraction.Maj(sql);
		DBinteraction.disconnect();
		return nb;
	}
	public Etudiant findEtudiantById(int id) 
	{
		Etudiant et = null;
		DBinteraction.connect();
		String sql = ("select * from etudiant where id="+id);
		ResultSet rs = DBinteraction.select(sql);
		try {
			if(rs.next())
			{
				et = new Etudiant();
				et.setId(rs.getInt(1));
				et.setLog(rs.getString(2));
				et.setPass(rs.getString(3));
				et.setNom(rs.getString(4));
				et.setPrenom(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBinteraction.disconnect();
		return et;
	}
    public List<Etudiant> allEtudiants()
    {
    	List<Etudiant> etu= new ArrayList<Etudiant>();
    	DBinteraction.connect();
    	String sql = "select * from etudiant";
    	ResultSet rs = DBinteraction.select(sql);
    	try {
			while(rs.next())
			{
				Etudiant et = new Etudiant();
				et.setId(rs.getInt(1));
				et.setLog(rs.getString(2));
				et.setPass(rs.getString(3));
				et.setNom(rs.getString(4));
				et.setPrenom(rs.getString(5));
				//ajouter l'etudiant dans la liste
				etu.add(et);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return etu;
    }
    public Etudiant authentification(String log , String pass)
    {
    	Etudiant et = null;
		DBinteraction.connect();
		ResultSet rs = DBinteraction.select("select * from etudiant where log='"+log+"' and pass='"+pass+"'");
		try {
			if(rs.next())
			{
				et = new Etudiant();
				et.setId(rs.getInt(1));
				et.setLog(rs.getString(2));
				et.setPass(rs.getString(3));
				et.setNom(rs.getString(4));
				et.setPrenom(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBinteraction.disconnect();
		return et;
    }
}
