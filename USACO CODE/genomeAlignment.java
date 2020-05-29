import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class genomeAlignment
{
    public static void assignValues(int [][] scoreMatrix, String genome1, String genome2)
    {
        for(int i=0; i<genome1.length(); i++)
        {
            for(int j=0; j<genome2.length(); j++)
            {
                //scoreMatrix[i][j]
            }
        }
    }
    
    
    public static void main (String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("genome.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("genome.out")));
        String genome1=f.readLine();
        String genome2=f.readLine();
        System.out.println("genome 1 " + genome1);
        System.out.println("genome 2 " + genome2);
        out.println("genome 1 " + genome1);
        out.println("genome 2 " + genome2);
        int[][] scoreMatrix=new int[genome1.length()][genome2.length()];
        
        
        
        //FormattedPrint
        for(int i=0; i<genome1.length(); i++)
        {
            if(i==0)
                out.print("  " + genome1.charAt(i) + " ");
            else
                out.print(genome1.charAt(i) + " ");
        }
        for(int i=0; i<genome1.length(); i++)
        {
            out.print("\n");
            out.print(genome2.charAt(i) + " " );
            for(int j=0; j<genome2.length(); j++)
            {
                out.print(scoreMatrix[i][j] + " ");
            }
        }
        
        out.close();
        System.exit(0);
        
    }
} 