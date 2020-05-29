/*ID: johnath8
 LANG: JAVA
 TASK: spin
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class spin
{
    static boolean[][] startingWedges=new boolean[5][360];
    static int[] numOfW=new int[5];
    static int[] speeds=new int[5];
    
    
    public static void main(String[] args) throws IOException 
    {
        
        BufferedReader f=new BufferedReader(new FileReader(new File("spin.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("spin.out")));
        
        for(int i=0; i<5; i++)
        {
            StringTokenizer temp=new StringTokenizer(f.readLine());
            speeds[i]=Integer.parseInt(temp.nextToken());
            numOfW[i]=Integer.parseInt(temp.nextToken());
            for(int j=0; j<numOfW[i]; j++)
            {
                int start=Integer.parseInt(temp.nextToken());
                int length=Integer.parseInt(temp.nextToken());
                for(int k=start; k<=start+length; k++)
                {
                    startingWedges[i][k%360]=true;
                }
            }
        }
        
        
        for(int i=0; i<360; i++)//time;
        {
            boolean[][] tempWedges=new boolean[5][360];
            for(int a=0; a<5; a++)
            {
                for(int b=0; b<360; b++)
                {
                    int val=(i*speeds[a])%360;
                    int index=b-val;
                    if(index<0)
                        index+=360;
                    tempWedges[a][b]=startingWedges[a][index];
                }
            }
            
            for(int j=0; j<360; j++)//current angle checking
            {
                
                boolean works=true;
                for(int k=0; k<5; k++)
                {
                    if(!tempWedges[k][j])
                    {
                        works=false;
                        break;
                    }
                }
                
                if(works)
                {
                    out.println(i);
                    out.close();
                    System.exit(0);
                }
            }
        }
        
        out.println("none");
        out.close();
    }
}
