package com.gi2.cobas6000fx.dao.tube; //need help

import java.time.LocalDate;

public class Tube {
    
    public final Patient patient;
    private String tubeCode;
    public final Analyse[] analyse;


    public Tube(Patient patient, String tubeCode, Analyse[] analyse) {
        
        assert !tubeCode.isEmpty();

        this.tubeCode = tubeCode;
        this.patient = patient; /// nsouel se7tani
        this.analyse = analyse;
    }

    public String getTubeCode(){
        return tubeCode;
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Tube)) return false;
        Tube p = (Tube)o;
        return this.tubeCode.equals(p.tubeCode);
    }

    public int hashCode(){
        return this.tubeCode.hashCode();
    }

    public String toString(){
        return String.format(
            "Tube(patient info : %s, tubeCode = %s, analyse = %s)", //khassni tosting dyalkum tkun mgada
            this.patient.tosting, this.tubeCode, this.analyse.toString()
        );
    }
    
}
