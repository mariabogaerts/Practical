/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Mariunda
 */
public class PeptideCoincidence {
    String seq;
    Integer start;
    String defLine;
    
    public PeptideCoincidence(String seq, int start){
        this.seq = seq;
        this.start = start;
    }
    
    // Get length (calculated when setting seq)
    public int getLength() {
        return seq.length();
    }
    
    // Get sequence
    public String getSeq() {
        return this.seq;
    }
    
    // Set sequence
    public String setSeq(String s) {
        this.seq = s;
        return s;
    }
    
    // Get the start point of the peptide
    public Integer getStart() {
        return this.start;
    }
    
    // Set the start point of the peptide
    public Integer setStart(Integer s) {
        this.start = s;
        return s;
    }
    
    //Get the end position of the peptide
    public Integer getStop() {
        return this.start + this.getLength();
    }
    
    //Get the definition line (DefLine)
    public String getDefLine() {
        return this.defLine;
    }
    
    //Set the definition line (DefLine)   
    public String setDefLine(String d) {
        this.defLine = d;
        return d;
    }
    
    public String getDescription() {
        // NOTE: we sum one to start in order to have a result equal to the CSV (because the first letter is at position zero)
        return "Start: " + (this.getStart() + 1) + "\tStop: " + this.getStop() + "\tDefinition line: " + getDefLine() + "\tSeq: " + this.getSeq();
    }
}
