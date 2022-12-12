package com.gi2.cobas6000fx.dao.patient;

import java.time.LocalDate;

public class Patient {
    
    private final String cin;
    private String fullName;
    private final LocalDate dob;

    public Patient(String fullName, String cin, LocalDate dob) {
        this.fullName = fullName;
        this.cin = cin;
        this.dob = dob;
    }

    public String getFullName(){
        return fullName;
    }

    public String getCin(){
        return cin;
    }

    public LocalDate getDob(){
        return dob;
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Patient)) return false;
        Patient p = (Patient)o;
        return this.cin.equals(p.cin);
    }

    public int hashCode(){
        return this.cin.hashCode();
    }

    public String toString(){
        return String.format(
            "Patient(cin= %s, fullName = %s, dob = %s)",
            this.cin, this.fullName, this.dob.toString()
        );
    }
    
}
