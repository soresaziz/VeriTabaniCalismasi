package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.entity.Film;
import com.entity.Kategori;

public class FilmDAO {

	public ArrayList<Film> butunFilmleriGetir() {

		ArrayList<Film> filmler = new ArrayList<Film>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/filmProjesi", "root", "sly6465");

			String sorgu = "select film.id,film.name,film.year,yonetmen.name AS y_name,kategori.name AS k_name from film,kategori,yonetmen where film.y_id=yonetmen.id and film.k_id=kategori.id";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sorgu);

			while (rs.next()) {
				Film f = new Film(rs.getInt("id"), rs.getString("name"),
						rs.getInt("year"), rs.getString("y_name"),
						rs.getString("k_name"));
				filmler.add(f);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return filmler;
	}

	// kategoriye ait filmleri getirir

	public ArrayList<Film> kategoriyeAitFilmleriGetir(int kategoriId) {

		ArrayList<Film> filmler = new ArrayList<Film>();

		Connection conn = ConnectionManager.getconnection();

		String sorgu = "select * from film where k_id=?";

		try {
			PreparedStatement prstm = conn.prepareStatement(sorgu);
			// Soru iﬂareti yerine kategroi id yi set ettik güvenli bir yol veya
			// select * from film where k_id= + kategoriId bu sql injection yer
			// "OR 1=1 derse comment out olur patlar :)
			prstm.setInt(1, kategoriId);
			// Sorgu sonucu bir resulset olarak doner sonra tek tek okuruz
			ResultSet rs = prstm.executeQuery();
			while (rs.next()) {
				Film f = new Film(rs.getInt("id"), rs.getString("name"),rs.getInt("year"));
				filmler.add(f);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return filmler;
	}

}
