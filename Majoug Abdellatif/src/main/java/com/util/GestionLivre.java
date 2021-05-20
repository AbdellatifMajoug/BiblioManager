package com.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestionLivre {
	
	public int AddLivre(String name , int categorie , String auteur ) 
	{
		DBinteraction.connect();
		String sql = "insert into livre(name , categorie , auteur ) values ('"+name+"','"+categorie+"','"+auteur+"')";
		int nb = DBinteraction.Maj(sql);
		DBinteraction.disconnect();
		return nb;
	}
    public List<Livre> findLivreByCategorie(String cat)
    {
    	List<Livre> liv= new ArrayList<Livre>();
    	GestionCategorie c = new GestionCategorie();
    	DBinteraction.connect();
    	String sql = "select * from livre where categorie="+c.findCategorieByname(cat);
    	ResultSet rs = DBinteraction.select(sql);
    	try {
			while(rs.next())
			{
				Livre l = new Livre();
				l.setName(rs.getString(1));
				l.setCategorie(rs.getInt(2));
				l.setAuteur(rs.getString(3));
				//ajouter le livre dans la liste
				liv.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return liv;
    }
}
