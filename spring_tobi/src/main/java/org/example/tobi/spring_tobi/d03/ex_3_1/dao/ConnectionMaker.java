package org.example.tobi.spring_tobi.d03.ex_3_1.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
    Connection makenewConnection() throws ClassNotFoundException, SQLException;
}
