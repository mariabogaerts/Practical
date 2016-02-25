
import java.io.BufferedReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mariunda
 */
public class Fasta {
    String header;
    String peptide;
    
    // This is used when we are reading a FASTA file
    public Fasta (BufferedReader bf) {
        String nextLine;
        
        this.header = "";
        this.peptide = "";
        
        try {
            nextLine = bf.readLine();
            while (nextLine != null){
                if (nextLine.startsWith(">")) {
                    header = header + nextLine;
                } else {
                    peptide = peptide + nextLine;
                }
                nextLine = bf.readLine();
            }
        } catch (Exception e) {
            System.out.println("Exception reading a Fasta from disk: "+e.getMessage());
        }
    }
    // Different ways to call the class with different arguments
    public Fasta(String peptide, String header) {
        this.peptide = peptide;
        this.header = header;
    }
    
    public Fasta(String peptide) {
        this.peptide = peptide;
        this.header = "";
    }
    
    public Fasta() {
        this.peptide = "";
        this.header = "";
    }
    
    // Get the peptide from the FASTA file
    public String getPeptide() {
        return this.peptide;
    }

    // Set the peptide from the FASTA file    
    public String setPeptide(String p) {
        this.peptide = p;
        return p;
    }

    // Get the header from the FASTA file with the information about the peptide/protein    
    public String getHeader() {
        return this.header;
    }

    // Set the header from the FASTA file with the information about the peptide/protein       
    public String setHeader(String h) {
        this.header = h;
        return h;
    }

    // Get the length of the peptide from the FASTA file
    public int getLength() {
        return this.peptide.length();
    }
    
    /*
    Function to search a peptide inside our FASTA
    
    Receive the peptide to search
    Return the position or null if not found
    */
    public PeptideCoincidence searchPeptideCoincidence(String pep) {
        int start = this.peptide.indexOf(pep);
        
        if (start >= 0) {
            return new PeptideCoincidence(pep, start); 
        } else {
            return null;
        }
    }
}
