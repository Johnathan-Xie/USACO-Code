/*ID: johnath8
 LANG: JAVA
 TASK: whereami
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class whereami
{
    
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f=new BufferedReader(new FileReader(new File("whereami.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
        int length=Integer.parseInt(f.readLine());
        String str=f.readLine();
        ArrayList<String> seen=new ArrayList<String>();
        int longestString=0;
        for(int i=0; i<str.length(); i++)//start
        {
            for(int j=1; j<str.length()-i+1; j++)//len
            {
                
               
                
                String temp=str.substring(i, i+j);
                
                if(seen.contains(temp))
                    longestString=Math.max(longestString, temp.length());
                else
                    seen.add(temp);
            }
        }
        out.println(longestString+1);
        out.close();
    }
}
