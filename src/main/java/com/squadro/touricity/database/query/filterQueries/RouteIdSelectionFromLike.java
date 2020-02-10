package com.squadro.touricity.database.query.filterQueries;

import com.squadro.touricity.database.query.SelectionQuery;
import com.squadro.touricity.database.result.QueryResult;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteIdSelectionFromLike extends SelectionQuery {

	private final int minRate;
	private final List<String> list;

	public RouteIdSelectionFromLike(int minRate) {
		this.minRate = minRate;
		list = new ArrayList<String>();
	}

	public String getQuery() {
		return "SELECT route_id" +
				"FROM DB_ROUTE_LIKE " +
				"INNER JOIN DB_ROUTE ON DB_ROUTE.route_id = DB_ROUTE_LIKE.route_id" +
				"INNER JOIN DB_LIKE ON DB_ROUTE_LIKE.like_id = DB_LIKE.like_id" +
				"WHERE DB_LIKE.score >= " + minRate;
	}

	public boolean onResult(QueryResult result) throws SQLException {
		while (result.getResultSet().next()) {
			list.add(result.getResultSet().getString("route_id"));
		}
		return false;
	}

	public List<String> getList() {
		return list;
	}
}
