package com.gi2.cobas6000fx.dao.patient;

import java.time.LocalDate;

public class Patient {
    
    public final String cin;
    private String fullName;
    public final LocalDate dob;

    public Patient(String fullName, String cin, LocalDate dob) {
        
        assert !fullName.isEmpty();
        assert !cin.isEmpty();

        this.cin = cin;
        this.fullName = fullName;
        this.dob = dob;
    }

    public String getFullName(){
        return fullName;
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
