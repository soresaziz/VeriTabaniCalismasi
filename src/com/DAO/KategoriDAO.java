package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entity.Kategori;

public class KategoriDAO {

	public ArrayList<Kategori> butunKategorileriGetir() {

		ArrayList<Kategori> kategoriler = new ArrayList<Kategori>();

		Connection conn = ConnectionManager.getconnection();

		String query = "select * from kategori";

		try {
			//preparedStatement sql injection yemez daha güvenlidir.
			PreparedStatement prstm = conn.prepareStatement(query);
			ResultSet rs = prstm.executeQuery();
			while (rs.next()) {
				Kategori k = new Kategori(rs.getInt("id"), rs.getString("name"));
				kategoriler.add(k);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return kategoriler;
	}

}
