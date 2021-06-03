package com.tactfactory.enchere.daogen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

abstract class Dao<T, PK> {
	public List<T> getAll() {
		final List<T> result = new ArrayList<>();
//		final String query = new QueryBuilder().addFrom(this.tableName()).addSelect("*").query();
		final String query = String.format("SELECT * FROM %s", tableName());

		try (
				final Connection cnx = ConnectionProvider.getInstance().getConnection();
				final PreparedStatement ps = cnx.prepareStatement(query)) {
			final ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				result.add(hydrate(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public T getOne(PK primaryKey) {
		T result = null;
		final String query = String.format("SELECT * FROM %s WHERE %s = %s", tableName(), pkName(), "" + primaryKey);

		try (
				final Connection cnx = ConnectionProvider.getInstance().getConnection();
				final PreparedStatement ps = cnx.prepareStatement(query)) {
			final ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				result = hydrate(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public void delete(PK primaryKey) {
		final String query = String.format("DELETE FROM %s WHERE %s = %s", tableName(), pkName(), "" + primaryKey);

		try (
				final Connection cnx = ConnectionProvider.getInstance().getConnection();
				final PreparedStatement ps = cnx.prepareStatement(query)) {
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected abstract String tableName();

	protected abstract T hydrate(final ResultSet rs) throws SQLException;

	protected String pkName() {
		return "id";
	}
}
