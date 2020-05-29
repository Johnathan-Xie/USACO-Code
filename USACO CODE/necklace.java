/*ID: johnath8
 LANG: JAVA
 TASK: friday
 */
import java.io.*;
import java.util.*;
import java.lang.Math;
import java.util.Scanner;
class necklace
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("necklace.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("necklace.out")));
        int numberOfBeads=f.readline();
        StringTokenizer st = new StringTokenizer(f.readLine());
        String[] necklace = new String[numberOfbeads];
        for(i=0; i<numberOfBeads; i++)
        {
            necklace[i]=st.nextToken();
        }
            
        out.close();
        System.exit(0);
    }
}

