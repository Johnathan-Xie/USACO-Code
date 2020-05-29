 /*ID: johnath8
 LANG: JAVA
 TASK: ratios
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class ratios
{
    static int[][] feeds=new int[4][3];//first one is the goal
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f=new BufferedReader(new FileReader(new File("ratios.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ratios.out")));
        for(int i=0; i<4; i++)
        {
            StringTokenizer st=new StringTokenizer(f.readLine());
            for(int j=0; j<3; j++)
                feeds[i][j]=Integer.parseInt(st.nextToken());
        }
        
        int[][] test=new int[3][3];
        int opt=Integer.MAX_VALUE;
        for(int i=0; i<101; i++)
        {
            for(int j=0; j<101; j++)
            {
                for(int k=1; k<101; k++)
                {
                    int[] temp=new int[3];
                    for(int b=0; b<3; b++)
                    {
                        temp[b]+=feeds[1][b]*i+feeds[2][b]*j+feeds[3][b]*k;
                    }
                    boolean works=true;
                    int ratio=(int)(temp[0]/feeds[0][0]);
                    for(int b=0; b<temp.length; b++)
                    {
                        if(feeds[0][b]*ratio!=temp[b])
                        {
                            works=false;
                            break;
                        }
                    }
                    if(works)
                    {
                        System.out.println(i+ " "+ j+ " "+ k);
                        System.out.println(((i+j+k)<<21) + (i<<14) + (j<<7) + k);
                        opt=Math.min(opt, ((i+j+k)<<21) + (i<<14) + (j<<7) + k);
                    }
                }
            }
        }
        if(opt==Integer.MAX_VALUE)
        {
            out.println("NONE");
            out.close();
            System.exit(0);
        }
        int optI=(opt%(1<<21))>>14;
        int optJ=(opt%(1<<14))>>7;
        int optK=opt%(1<<7);
        int finalRatio=(optI*feeds[1][0]+optJ*feeds[2][0]+optK*feeds[3][0])/feeds[0][0];
        
        out.println(optI+" "+optJ+" "+optK+" "+finalRatio);
        out.close();
    }
}
