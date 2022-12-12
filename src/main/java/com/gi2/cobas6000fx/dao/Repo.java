package com.gi2.cobas6000fx.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public interface Repo<T, P> {

    default Connection connect() throws SQLException{
        return DriverManager.getConnection("jdbc:sqlite:../db.sqlite3");
    }

    T find(P id);

    List<T> findAll();

    boolean add(T t);

    @SuppressWarnings("unchecked")
    boolean add(T ...l);
   
    boolean remove(P id);

}
