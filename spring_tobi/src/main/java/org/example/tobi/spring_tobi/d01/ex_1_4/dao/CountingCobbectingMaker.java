package org.example.tobi.spring_tobi.d01.ex_1_4.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class CountingCobbectingMaker implements ConnectionMaker {

    int counter = 0;
    private ConnectionMaker realConnectionMaker;

    public CountingCobbectingMaker(ConnectionMaker realConnectionMaker) {
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
