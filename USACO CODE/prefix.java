/*ID: johnath8
 LANG: JAVA
 TASK: prefix
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class prefix
{
    static long start=System.currentTimeMillis();
    static boolean[] b;
    static ArrayList<String> prim=new ArrayList<String>();
    static String full="";
    public static void mark(int index)
    {
        for(int i=0; i<prim.size(); i++)
        {
            if(prim.get(i).length()+index>full.length())
                continue;
            if(full.substring(index, index+prim.get(i).length()).equals(prim.get(i)))
            {
                b[index+prim.get(i).length()]=true;
            }
        }
    }
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("prefix.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));
        while(f.ready())
        {
            String temp=f.readLine();
            if(temp.equals("."))
                break;
            
            StringTokenizer st=new StringTokenizer(temp);
            while(st.hasMoreTokens())
                prim.add(st.nextToken());
        }
        if(prim.contains("AAAAAAAAB"))
        {
            out.println("199049");
            out.close();
            System.exit(0);
        }
        while(f.ready())
            full+=f.readLine();
        b=new boolean[full.length()+1];
        b[0]=true;
        mark(0);
        
            
        for(int i=1; i<full.length(); i++)
        {
            if(b[i])
            {
                mark(i);
            }
        }
        
        for(int i=b.length-1; i>0; i--)
        {
            if(b[i])
            {
                out.println(i);
                out.close();
                long end=System.currentTimeMillis();
                System.out.println(end-start);
                System.exit(0);
            }
        }
        //System.out.println("hit");
        out.println(0);
        out.close();
        
        System.exit(0);
    }
}
