/*ID: johnath8
 LANG: JAVA
 TASK: milk3
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class milk3
{
    static boolean[][] found=new boolean[21][21];
    static boolean[]amounts=new boolean[21];
    static int a;
    static int b;
    static int c;
       
    
    public static void main(String[] args) throws IOException 
    {
        
        BufferedReader f = new BufferedReader(new FileReader("milk3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
        
        StringTokenizer st=new StringTokenizer(f.readLine());
        a=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        iterate(0, 0, c);
        for(int i=0; i<c; i++)
        {
            if(amounts[i])
                out.print(i + " ");
        }
        out.println(c);
        out.close();
    }
    private static void iterate(int x, int y, int z)
    {
        if(found[x][y]==true) return;
        found[x][y]=true;
        if(x==0)
            amounts[z]=true;
        if(x>0 && z<c)
            iterate(Math.max(x+z-c, 0), y, Math.min(z+x ,c));
        if(x>0 && y<b)
            iterate(Math.max(x+y-b, 0), Math.min(y+x ,b), z);
        if(y>0 && z<c)
            iterate(x, Math.max(y+z-c, 0), Math.min(z+y ,c));
        if(y>0 && x<a)
            iterate(Math.min(y+x ,a), Math.max(x+y-a, 0), z);
        if(z>0 && x<a)
            iterate(Math.min(z+x ,a), y, Math.max(x+z-a, 0));
        if(z>0 && y<b)
            iterate(x, Math.min(y+z ,b), Math.max(y+z-b, 0));
    }
}
