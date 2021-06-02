package com.tactfactory.enchere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.Driver;

public class MaDao {
	private static final String STMT_GET_ALL = "SELECT * FROM app_articles";
	private static final String STMT_GET_ONE = STMT_GET_ALL + " WHERE id = ?";

	static {
		try {
			DriverManager.registerDriver(new Driver());
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public List<MonJavaBean> getAll() {
		final List<MonJavaBean> result = new ArrayList<>();

		try (final Connection cnx = this.getCnx(); final PreparedStatement ps = cnx.prepareStatement(STMT_GET_ALL)) {
			final ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				result.add(this.hydrate(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public MonJavaBean getOne(final long id) {
		MonJavaBean result = null;

		try (final Connection cnx = this.getCnx(); final PreparedStatement ps = cnx.prepareStatement(STMT_GET_ONE)) {
			ps.setLong(1, id);
			final ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				result = this.hydrate(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	private MonJavaBean hydrate(final ResultSet rs) throws SQLException {
		final MonJavaBean bean = new MonJavaBean();

		bean.setId(rs.getLong("id"));
		bean.setNom(rs.getString("nom"));

		return bean;
	}

	private Connection getCnx() throws SQLException {
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/cours_enchere", "dev", "dev");
	}
}
