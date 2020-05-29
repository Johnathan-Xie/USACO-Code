/*ID: johnath8
 LANG: JAVA
 TASK: ttwo
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class ttwo
{
    //rotation number
    // 0
    //3 1
    // 2
    static char[][] map=new char[10][10];
    static int[] fpos=new int[3];
    static int[] cpos=new int[3];
    public static void print2DArray(char[][] in) throws IOException
    {
        
        for(int i=0; i<in[0].length; i++)
        {
            for(int j=0; j<in.length; j++)
            {
                System.out.print(in[i][j]+" ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    
    public static void move()
    {
        if(fpos[2]==0)
        {
            if((fpos[0]-1)>=0 && map[fpos[0]-1][fpos[1]]!='*')
                fpos[0]-=1;
            else
                fpos[2]=(fpos[2]+1)%4;
        }
        else if(fpos[2]==1)
        {
            if((fpos[1]+1)<=9 && map[fpos[0]][fpos[1]+1]!='*')
                fpos[1]+=1;
            else
                fpos[2]=(fpos[2]+1)%4;
        }
        else if(fpos[2]==2)
        {
            if((fpos[0]+1)<=9 && map[fpos[0]+1][fpos[1]]!='*')
                fpos[0]+=1;
            else
                fpos[2]=(fpos[2]+1)%4;
        }
        else
        {
            if((fpos[1]-1)>=0 && map[fpos[0]][fpos[1]-1]!='*')
                fpos[1]-=1;
            else
                fpos[2]=(fpos[2]+1)%4;
        }
        
        if(cpos[2]==0)
        {
            if((cpos[0]-1)>=0 && map[cpos[0]-1][cpos[1]]!='*')
                cpos[0]-=1;
            else
                cpos[2]=(cpos[2]+1)%4;
        }
        else if(cpos[2]==1)
        {
            if((cpos[1]+1)<=9 && map[cpos[0]][cpos[1]+1]!='*')
                cpos[1]+=1;
            else
                cpos[2]=(cpos[2]+1)%4;
        }
        else if(cpos[2]==2)
        {
            if((cpos[0]+1)<=9 && map[cpos[0]+1][cpos[1]]!='*')
                cpos[0]+=1;
            else
                cpos[2]=(cpos[2]+1)%4;
        }
        else
        {
            if((cpos[1]-1)>=0 && map[cpos[0]][cpos[1]-1]!='*')
                cpos[1]-=1;
            else
                cpos[2]=(cpos[2]+1)%4;
        }
        
        
    }
    
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("ttwo.in"));
        PrintWriter out = new PrintWriter(new File("ttwo.out"));
        
        for(int i=0; i<10; i++)
        {
            String temp=f.readLine();
            for(int j=0; j<10; j++)
            {
                map[i][j]=temp.charAt(j);
                if(map[i][j]=='F')
                {
                    fpos[0]=i;
                    fpos[1]=j;
                    fpos[2]=0;
                    map[i][j]='.';
                }
                else if(map[i][j]=='C')
                {
                    cpos[0]=i;
                    cpos[1]=j;
                    cpos[2]=0;
                    map[i][j]='.';
                }
            }
        }
        //print2DArray(map);
        //System.out.println(map[0][4]);
        for(int i=0; i<1000000; i++)
        {
            //System.out.println(i+": "+Arrays.toString(fpos));
            //System.out.println(i+": "+Arrays.toString(cpos));
            move();
            if(fpos[0]==cpos[0] && fpos[1]==cpos[1])
            {
                
                out.println(i+1);
                out.close();
                System.exit(0);
            }
        }
        out.println(0);
        out.close();
        System.exit(0);
    }
}
