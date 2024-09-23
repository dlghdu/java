package org.example.tobi.spring_tobi.d03.ex_3_5;


import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementSetter {
    void setParmeters(PreparedStatement ps) throws SQLException;
}
