package org.example.tobi.spring_tobi.d03.ex_3_6.dao;

import org.example.tobi.spring_tobi.d03.ex_3_6.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao_v1 {

    private JdbcTemplate jdbcTemplate;

    public UserDao_v1(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void add(User user) {
        this.jdbcTemplate.update(
                "insert into user(id, name, password) values(?,?,?)",
                user.getId(), user.getName(), user.getPassword()
        );
    }

    public void deleteAll() {
        this.jdbcTemplate.update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        return con.prepareStatement("delete from user");
                    }
                }
        );
    }

    public List<User> getAll() {
        return this.jdbcTemplate.query(
                "select * from user",
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        User user = new User();
                        user.setId(rs.getString("id"));
                        user.setName(rs.getString("name"));
                        user.setPassword(rs.getString("password"));

                        return user;
                    }
                }
        );
    }

    public User get(String id){
        return this.jdbcTemplate.queryForObject(
                "select * from user where id = ?",
                new Object[]{id},
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        User user = new User();
                        user.setId(rs.getString("id"));
                        user.setName(rs.getString("name"));
                        user.setPassword(rs.getString("password"));

                        return user;
                    }
                }
        );
    }

    public int getCount() throws SQLException {
        return this.jdbcTemplate.queryForObject(
                "select count(*) from user",
                Integer.class
        );
    }


}