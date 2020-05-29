/*ID: johnath8
 LANG: JAVA
 TASK: preface
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class preface
{
    static String[] combo={"I","IV","V","IX","X","XL","L","XC","C","CD", "D", "CM", "M"};
    static int[] vals={1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    static int[] count=new int[7];
    public static void countAll(int in)
    {
        int temp=in;
        for(int i=combo.length-1; i>=0; i--)
        {
            if(in>=vals[i])
            {
                in-=vals[i];
                for(int j=0; j<combo[i].length(); j++)
                {
                    char curr=combo[i].charAt(j);
                    if(curr=='I')
                        count[0]++;
                    else if(curr=='V')
                        count[1]++;
                    else if(curr=='X')
                        count[2]++;
                    else if(curr=='L')
                        count[3]++;
                    else if(curr=='C')
                        count[4]++;
                    else if(curr=='D')
                        count[5]++;
                    else
                        count[6]++;
                }
                i=combo.length;
            }
        }
    }
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("preface.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
        int n=Integer.parseInt(f.readLine());
        
        
        for(int k=1; k<n+1; k++)
        {
            countAll(k);
        }
        int highest=0;
        for(int i=count.length-1; i>=0; i--)
        {
            if(count[i]!=0)
            {
                highest=i;
                break;
            }
        }
        System.out.println(highest);
        char[] index={'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        for(int i=0; i<=highest; i++)
            out.println(index[i]+ " " +count[i]);
        out.close();
        
    }
}
