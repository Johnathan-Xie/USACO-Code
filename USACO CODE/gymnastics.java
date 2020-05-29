 /*ID: johnath8
 LANG: JAVA
 TASK: gymnastics
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class gymnastics
{
    
    public static void main(String[] args) throws IOException 
    {
        Scanner f=new Scanner(new File("gymnastics.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
        //check all possible pairs
        int numOfSes=f.nextInt();
        int numOfCows=f.nextInt();
        int[][] rank=new int[numOfSes][numOfCows];
        for(int i=0; i<numOfSes; i++)
        {
            for(int j=0; j<numOfCows; j++)
            {
                rank[i][j]=f.nextInt();
            }
        }
        int counter=0;
        for(int i=1; i<numOfCows+1; i++)
        {
            for(int j=1; j<numOfCows+1; j++)
            {//testing if i is better than j
                if(i==j)
                    continue;
                boolean consistent=true;
                for(int a=0; a<numOfSes; a++)//num row scanning
                {
                    for(int b=0; b<numOfCows; b++)//scanning which comes first
                    {
                        //System.out.println("a b val"+ " "+ a+ " "+b+ " "+rank[a][b]);
                        //System.out.println(rank[a][b]);
                        if(rank[a][b]==j)
                        {
                            //System.out.println("fail" +" "+i+ " "+j);
                            consistent=false;
                            
                            
                            break;
                        }
                        else if(rank[a][b]==i)
                        {
                            //System.out.println("success" +" "+i+ " "+j);
                            
                            
                            break;
                            
                        }
                    }
                    if(!consistent)
                        break;
                }
                if(consistent)
                    counter++;
            }
        }
        out.println(counter);
        out.close();
    }
}
