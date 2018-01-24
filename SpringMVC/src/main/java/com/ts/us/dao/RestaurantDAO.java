package com.ts.us.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ts.us.dto.Restaurant;
import com.ts.us.dto.User;

public class RestaurantDAO {

	@Autowired
	private DataSource datasource;
	private JdbcTemplate jdbcTemplet;

	public DataSource getDatasource() {
		return datasource;
	}

	public void setDatasource(DataSource dataSource) {
		this.datasource = dataSource;
		this.jdbcTemplet = new JdbcTemplate(this.datasource);
	}

	public Restaurant set(final Restaurant r) {

		System.out.println(datasource);
		String query = "insert into restaurant(govt_registration_id,name,password) values(?,?,?)";
		int n = jdbcTemplet.update(query, new Object[] { r.getGovtRegistrationId(), r.getName(), r.getPassword() });

		if (n > 0) {
			System.out.println("record inserted");
		} else {
			System.out.println("some problem");
		}
		jdbcTemplet.query("select max(restaurant_id) from restaurant", new ResultSetExtractor<Restaurant>() {
			public Restaurant extractData(ResultSet rs) throws SQLException {
				if (rs.next()) {
					r.setId(rs.getInt(1));
				}
				return r;
			}
		});

		return r;
	}

	public void updateLogoAddress(String logoName, int id) {
		String query = "update restaurant set logo_name=? where restaurant_id=?";
		int n = jdbcTemplet.update(query, new Object[] { logoName, id });

		if (n > 0) {
			System.out.println("record inserted");
		} else {
			System.out.println("some problem");
		}
	}

}
