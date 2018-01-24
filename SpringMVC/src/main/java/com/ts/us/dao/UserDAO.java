package com.ts.us.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ts.us.dto.User;

public class UserDAO {

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

	public void save(final User user) {

		System.out.println(datasource);
		String query = "insert into user(name,gender,email,password,date_of_birth,mobile_number) values(?,?,?,?,?,?)";
		int n = jdbcTemplet.update(query, new Object[] { user.getName(), user.getGender(), user.getEmail(),
				user.getPassword(), user.getDate(), user.getMobileNo() });

		if (n > 0) {
			System.out.println("record inserted");

		} else {
			System.out.println("some problem");
		}
		jdbcTemplet.query("select max(user_id) from user", new ResultSetExtractor<User>() {
			public User extractData(ResultSet rs) throws SQLException {
				if (rs.next()) {
					user.setId(rs.getInt(1));
				}
				return user;
			}
		});

		System.out.println(user.getId());
	}

}