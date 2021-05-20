package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBinteraction {
	
	static String url;
	static Connection con;
	static Statement st;
	
	
	public static void connect()
	{
		try {
			//1-Chargement du pilote
			Class.forName("com.mysql.jdbc.Driver");
			//2-Definir l'url
			url="jdbc:mysql://localhost/biblio";
			//3-Etablir la connexion
			con = DriverManager.getConnection(url, "root", "");
			//4-Créer une instruction
			st = con.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static int Maj(String sql)
	{	
		int nb = 0;
		try {
		nb = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nb;
	}
	public static ResultSet select(String sql)
	{
		ResultSet rs = null;
		try {
		rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public static void disconnect()
	{
		//7-Fermeture
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
