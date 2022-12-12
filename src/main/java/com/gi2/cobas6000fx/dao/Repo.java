package com.gi2.cobas6000fx.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public interface Repo<T, P> {

    String DBPATH = "/home/mohcine/Desktop/cobas_6000_fx/db.sqlite3";

    default Connection connect() throws SQLException{
        return DriverManager.getConnection("jdbc:sqlite:"+DBPATH);
    }

    T find(P id);

    List<T> findAll();

    @SuppressWarnings("unchecked")
    boolean add(T ...l);
   
    boolean remove(P id);

}
