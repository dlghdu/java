package org.example.tobi.spring_tobi.ex_1_3.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
    Connection makenewConnection() throws ClassNotFoundException, SQLException;
}
