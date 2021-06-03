package com.tactfactory.enchere.daogen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Permet une gestion dans n'importe quel ordre des elements d'une requete SQL (SELECT, FROM, HAVING, ORDER BY).
 */
public class QueryBuilder {
	/**
	 * Clef = alias
	 * Valeur = table
	 */
	private Map<String, String> froms = new HashMap<>();

	private List<String> selects = new ArrayList<>();

	public QueryBuilder addSelect(final String select) {
		selects.add(select);
		return this;
	}

	public QueryBuilder addFrom(final String table) {
		froms.put(table, table);
		return this;
	}

	public QueryBuilder addFrom(final String table, final String alias) {
		froms.put(alias, table);
		return this;
	}

	public String query() {
		// [nom, id] => "nom,id"
//		String result = "SELECT " + selects.stream().collect(Collectors.joining(",").toString()
//				+ " FROM ");

		String result = "";

		// ...

		return result;
	}
}
