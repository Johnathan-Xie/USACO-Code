/*ID: johnath8
 LANG: JAVA
 TASK: gift1
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class gift1
{
    public static int searchForMatches(String[] a, String b)
    {
        int hit = 0;
        for(int i=0; i<a.length; i++)
        {
            if(a[i].matches(b)==true)
            {
                System.out.print(i);
                hit=i;
            }
        }
        return hit;
    }
    public static void printArray(String[] a)
    {
        for (int i=0; i<a.length; i++)
        {
            System.out.print(a[i]);
        }
    }
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int numberOfPeople = Integer.parseInt(st.nextToken());
        String[] finalLedgerNames = new String[numberOfPeople];
        int[] finalLedgerValues = new int[numberOfPeople];
        for(int i=0; i<numberOfPeople; i++)
        {
            finalLedgerNames[i]=f.readLine();
            finalLedgerValues[i]=0;
        }
        printArray(finalLedgerNames);
        while(f.ready()!=false)
        {
            String giver=f.readLine();
            System.out.println(giver);
            StringTokenizer reader = new StringTokenizer(f.readLine());
            int valueGiven = Integer.parseInt(reader.nextToken());
            int numberOfParticipants = Integer.parseInt(reader.nextToken());
            
            if(numberOfParticipants==0)
            {
                finalLedgerValues[searchForMatches(finalLedgerNames, giver)]+=-(valueGiven)+(valueGiven%(numberOfParticipants+1));
            }
            else
            {
                finalLedgerValues[searchForMatches(finalLedgerNames, giver)]+=-(valueGiven)+(valueGiven%numberOfParticipants);
            }
            
            
            for(int i=0; i<numberOfParticipants; i++)
            {
                String currentName=f.readLine();
                System.out.println(currentName + " ");
                printArray(finalLedgerNames);
                System.out.println(searchForMatches(finalLedgerNames, currentName));
                finalLedgerValues[searchForMatches(finalLedgerNames, currentName)]+=Math.floor(valueGiven/numberOfParticipants);
                //printArray(finalLedgerValues);
            }
            printArray(finalLedgerNames);
            
        }
        for(int i=0; i<numberOfPeople; i++)
        {
            out.println(finalLedgerNames[i] + " " + finalLedgerValues[i]);
        }
        out.close();
        System.exit(0);
        return;
    }
    
} 
