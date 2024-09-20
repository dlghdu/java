package org.example.tobi.spring_tobi.ex_1_4.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
    Connection makenewConnection() throws ClassNotFoundException, SQLException;
}
