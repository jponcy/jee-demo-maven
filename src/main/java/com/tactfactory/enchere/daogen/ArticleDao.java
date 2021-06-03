package com.tactfactory.enchere.daogen;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tactfactory.enchere.MonJavaBean;

public class ArticleDao extends Dao<MonJavaBean, Long> {

	@Override
	protected String tableName() {
		return "app_articles";
	}

	@Override
	protected MonJavaBean hydrate(ResultSet rs) throws SQLException {
		final MonJavaBean bean = new MonJavaBean();

		bean.setId(rs.getLong("id"));
		bean.setNom(rs.getString("nom"));

		return bean;
	}
}
