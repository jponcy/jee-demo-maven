package com.tactfactory.enchere.daogen;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDao extends Dao<Category, Long> {

	@Override
	protected String tableName() {
		return "app_categories";
	}

	@Override
	protected Category hydrate(ResultSet rs) throws SQLException {
		final Category result = new Category();

		result.setId(rs.getLong("id"));
		result.setLibelle(rs.getString("libelle"));

		return result;
	}
}
