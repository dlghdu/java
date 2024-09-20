package practice.e1.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
    Connection makenewConnection() throws ClassNotFoundException, SQLException;
}
