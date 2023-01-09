package com.gi2.cobas6000fx.dao.tube;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import com.gi2.cobas6000fx.dao.Repo;

public class TubeRepo implements Repo<Tube, String> {
    
    private static TubeRepo instance;

    public static TubeRepo getInstance(){
        if(instance == null){
            instance = new TubeRepo();
        }
        return instance;
    }

    @Override
    public Tube find(String tubeCode) {

        Tube p = null;

        final String sql = String.format(
            "SELECT * FROM Tube where tubeCode = '%s'", tubeCode
        );
    
        Statement stmt;
        ResultSet res;

        try (Connection conn = connect()) {

            stmt = conn.createStatement();
            res = stmt.executeQuery(sql);

            if(res.next()){
                p = new Tube(
                    res.getString("patient"),
                    tubeCode,
                    res.getString("analyse")
                );
            }

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;
    }

    @Override
    public List<Tube> findAll() {

        List<Tube> tubes = new ArrayList<>();

        final String sql = "SELECT * FROM Tube";

        Statement stmt;
        ResultSet res;

        try (Connection conn = connect()) {

            stmt = conn.createStatement();
            res = stmt.executeQuery(sql);

            while(res.next()){
                tubes.add(
                    new Tube(
                        res.getString("patient"), // se7tai help
                        res.getString("tubeCode"),
                        res.getString("analyse")  //ghada help
                    )
                );
            }

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tubes;
    }

    @Override
    public boolean add(Tube ...tubes) {
        // preparing the query
        String sql = "INSERT INTO `Tubes` VALUES ";
        for(Tube p: tubes){

            sql = String.join(", ", sql, String.format(
                "('%s', '%s', '%s')",
                p.patient.tosting(), //se7tani help
                p.getTubeCode(), 
                p.analyse.toString()
            ));

        }

        Statement stmt;
        int nRows = 0;
        try(Connection conn = connect()){

            stmt = conn.createStatement();
            nRows = stmt.executeUpdate(sql);

            stmt.close();
            conn.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
        return (nRows == tubes.length);
    }

    @Override
    public boolean remove(String cin) {
        String sql = String.format(
            "DELETE FROM Tube WHERE tubeCode='%s'", tubeCode
        );

        Statement stmt;
        boolean removed = false;

        try(Connection conn = connect()){
            stmt = conn.createStatement();
            removed = (stmt.executeUpdate(sql) == 1);
            stmt.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

        return removed;
    }

}
