package org.example.tobi.spring_tobi.d01.ex_1_5.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class CountingConnectinMaker implements ConnectionMaker {

    int counter = 0;
    private ConnectionMaker realConnectionMaker;

    public CountingConnectinMaker(ConnectionMaker realConnectionMaker) {
        this.realConnectionMaker = realConnectionMaker;
    }

    @Override
    public Connection makenewConnection() throws ClassNotFoundException, SQLException {
        this.counter++;
        return null;
    }

    public int getCounter() {
        return this.counter;
    }
}
