import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class cownomics
{
    
    //Debug static Printer debug;
    static int N;
    static int M;
    static int[][] genomes;
    public static boolean works(int i, int j, int k)
    {
        boolean[] seen=new boolean[78];
        for(int a=0; a<N; a++)
        {
            seen[genomes[a][i]*16+genomes[a][j]*4+genomes[a][k]]=true;
        }
        for(int a=N; a<2*N; a++)
        {
            if(seen[genomes[a][i]*16+genomes[a][j]*4+genomes[a][k]]==true)
                return false;
        }
        return true;
    }
    public static int charToInt(char in)
    {
        switch(in)
        {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'T':
                return 2;
            case 'G':
                return 3;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f=new BufferedReader(new FileReader(new File("cownomics.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
        StringTokenizer st=new StringTokenizer(f.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        //System.out.println(N+ " "+M);
        genomes=new int[2*N][M];
        for(int i=0; i<2*N; i++)
        {
            String temp=f.readLine();
            //System.out.println(temp);
            for(int j=0; j<M; j++)
            {
                //System.out.println(i+ " "+j);
                genomes[i][j]=charToInt(temp.charAt(j));
            }
        }
        int ans=0;
        for(int i=0; i<M; i++)
        {
            for(int j=i+1; j<M; j++)
            {
                for(int k=j+1; k<M; k++)
                {
                    if(works(i, j, k)) ans++;
                }
            }
        }
        out.println(ans);
        out.close();
        //Debug debug=new Printer("countCross.debug");
        
    }
}