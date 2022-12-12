package com.gi2.cobas6000fx.dao.patient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.gi2.cobas6000fx.dao.Repo;

public class PatientRepo implements Repo<Patient, String> {
    
    private static PatientRepo instance;

    public static PatientRepo getInstance(){
        if(instance == null){
            instance = new PatientRepo();
        }
        return instance;
    }

    @Override
    public Patient find(String cin) {

        Patient p = null;

        final String sql = String.format(
            "SELECT * FROM Patient where cin = %s", cin
        );
    
        Statement stmt;
        ResultSet res;

        try (Connection conn = connect()) {

            stmt = conn.createStatement();
            res = stmt.executeQuery(sql);

            if(res.next()){
                p = new Patient(
                    res.getString("fullname"),
                    cin,
                    LocalDate.parse(res.getString("dob"))
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
    public List<Patient> findAll() {

        List<Patient> patients = new ArrayList<>();

        final String sql = "SELECT * FROM Patient";

        Statement stmt;
        ResultSet res;

        try (Connection conn = connect()) {

            stmt = conn.createStatement();
            res = stmt.executeQuery(sql);

            while(res.next()){
                patients.add(
                    new Patient(
                        res.getString("fullname"),
                        res.getString("cin"),
                        LocalDate.parse(res.getString("dob"))
                    )
                );
            }

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patients;
    }

    @Override
    public boolean add(Patient t) {
        
        return false;
    }

    @Override
    public boolean add(Patient patients...) {
        String sql = "INSERT INTO Patient VALUES ";
        for(Patient p: patients){
            sql += String.format(
                "(%s, %s, %s)", p.getCin(), p.getFullName(), p.getDob().toString()
            );
        }

        Statement stmt;
        int i;

        try(Connection conn = connect()){

            stmt = conn.createStatement();
            i = stmt.executeUpdate(sql);

            System.out.println(i);

            stmt.close();
            conn.close();

        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean remove(String id) {
        // TODO Auto-generated method stub
        return false;
    }

}
