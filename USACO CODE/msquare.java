/*ID: johnath8
 LANG: JAVA
 TASK: msquare
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class msquare
{
    
    public static void main(String[] args) throws IOException 
    {
        long start=System.currentTimeMillis();
        BufferedReader f=new BufferedReader(new FileReader(new File("msquare.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("msquare.out")));
        StringTokenizer temp=new StringTokenizer(f.readLine());
        int[] in=new int[8];
        for(int i=0; i<8; i++)
            in[i]=Integer.parseInt(temp.nextToken());
        f.close();
        Square target=new Square(0, in, "");
        Queue<Square> queue=new LinkedList<Square>();
        Set<Integer> seen=new HashSet<Integer>();
        queue.add(new Square(0, new int[] {1, 2, 3, 4, 5, 6, 7, 8}, ""));
        Square curr=null;
        while(queue.size()!=0)
        {
            
            curr=queue.poll();
            //out.println(curr.getNum());
            if(seen.contains(curr.getNum())) continue;
            seen.add(curr.getNum());
            if(curr.getNum()==target.getNum()) break;
            queue.add(curr.a());
            queue.add(curr.b());
            queue.add(curr.c());
        }
        out.println(curr.n);
        out.println(curr.str);
        out.close();
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}
class Square
{
    public int n;
    private int[] config;
    public String str;
    public Square(int n, int[] config, String str)
    {
        this.n=n;
        this.config=config;
        this.str=str;
    }
    public int getNum()
    {
        int out=0;
        for(int i=0; i<8; i++)
        {
            out=out*10+this.config[i];
        }
        return out;
    }
    public Square a()
    {
        int[] out=new int[8];
        int[] curr=this.config;
        /*for(int i=0; i<8; i++)
        {
            out[7-i]=this.config[i];
        }*/
        out[0]=curr[7];
        out[1]=curr[6];
        out[2]=curr[5];
        out[3]=curr[4];
        out[4]=curr[3];
        out[5]=curr[2];
        out[6]=curr[1];
        out[7]=curr[0];
        return new Square(n+1, out, str+"A");
        
        
    }
    public Square b()
    {
        int[] out=new int[8];
        int[] curr=this.config;
        /*for(int i=0; i<4; i++)
        {
            out[(i+1)%4]=this.config[i];
            out[i+4]=this.config[(i+1)%4+4];
        }*/
        out[0]=curr[3];
        out[1]=curr[0];
        out[2]=curr[1];
        out[3]=curr[2];
        out[4]=curr[5];
        out[5]=curr[6];
        out[6]=curr[7];
        out[7]=curr[4];
        return new Square(n+1, out, str+"B");
    }
    public Square c()
    {
        int[] out=new int[8];
        int[] curr=this.config;
        /*for(int i=0; i<8; i++)
        {
            out[i]=this.config[i];
        }
        out[1]=this.config[6];
        out[2]=this.config[1];
        out[5]=this.config[2];
        out[6]=this.config[5];*/
        out[0]=curr[0];
        out[1]=curr[6];
        out[2]=curr[1];
        out[3]=curr[3];
        out[4]=curr[4];
        out[5]=curr[2];
        out[6]=curr[5];
        out[7]=curr[7];
        return new Square(n+1, out, str+"C");
    }
}
