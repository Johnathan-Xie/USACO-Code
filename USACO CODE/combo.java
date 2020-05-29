/*ID: johnath8
 LANG: JAVA
 TASK: combo
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class combo
{
    
    public static void add(String a, String b)
    {
        if(a.contains(b)==false)
        {
            a+=b;
        }
        
    }
    public static int compare(ArrayList<Integer>a, ArrayList<Integer>b)
    {
        int count=0;
        for(int i=0; i<a.size(); i++)
        {
            for(int j=0; j<b.size(); j++)
            {
                if((a.get(i)).equals(b.get(j)))
                    count++;
            }
        }
        return count;
    }
    public static int correct(int input, int n)
    {
        if(input%n!=0)
            return input%n;
        else
            return n;
    }
    
    public static void solve() throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("combo.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
        int n = Integer.parseInt(f.readLine());
        int[] a=new int[3];
        StringTokenizer ast=new StringTokenizer(f.readLine());
        int[] b=new int[3];
        StringTokenizer bst=new StringTokenizer(f.readLine());
        for(int i=0; i<3; i++)
        {
            a[i]=Integer.parseInt(ast.nextToken());
            b[i]=Integer.parseInt(bst.nextToken());
        }
        
        ArrayList<Integer> a0=new ArrayList<Integer>();
        a0.add(a[0]);
        ArrayList<Integer> a1=new ArrayList<Integer>();
        a1.add(a[1]);
        ArrayList<Integer> a2=new ArrayList<Integer>();
        a2.add(a[2]);
        ArrayList<Integer> b0=new ArrayList<Integer>();
        b0.add(b[0]);
        ArrayList<Integer> b1=new ArrayList<Integer>();
        b1.add(b[1]);
        ArrayList<Integer> b2=new ArrayList<Integer>();
        b2.add(b[2]);
        
        
        for(int j=1; j<3; j++)
        {
            int currA=correct(a[0]+j+n, n);
            int currB=correct(b[0]+j+n, n);
            int currA1=correct(a[0]-j+n, n);
            int currB1=correct(b[0]-j+n, n);
            
            if(a0.contains(currA)==false)
                a0.add(currA);
            if(b0.contains(currB)==false)
                b0.add(currB);
            if(a0.contains(currA1)==false)
                a0.add(currA1);
            if(b0.contains(currB1)==false)
                b0.add(currB1);
        }
        for(int j=1; j<3; j++)
        {
            int currA=correct(a[1]+j+n, n);
            int currB=correct(b[1]+j+n, n);
            int currA1=correct(a[1]-j+n, n);
            int currB1=correct(b[1]-j+n, n);
            
            if(a1.contains(currA)==false)
                a1.add(currA);
            if(b1.contains(currB)==false)
                b1.add(currB);
            if(a1.contains(currA1)==false)
                a1.add(currA1);
            if(b1.contains(currB1)==false)
                b1.add(currB1);
        }
        for(int j=1; j<3; j++)
        {
            int currA=correct(a[2]+j+n, n);
            int currB=correct(b[2]+j+n, n);
            int currA1=correct(a[2]-j+n, n);
            int currB1=correct(b[2]-j+n, n);
            
            if(a2.contains(currA)==false)
                a2.add(currA);
            if(b2.contains(currB)==false)
                b2.add(currB);
            if(a2.contains(currA1)==false)
                a2.add(currA1);
            if(b2.contains(currB1)==false)
                b2.add(currB1);
        }
        
        /*String[] aTotal=new String[a[0].length()*a[1].length()*a[2].length()];
         String[] bTotal=new String[b[0].length()*b[1].length()*b[2].length()];
         for(int i=0; i<a[0].length(); i++)
         {
         for(int j=0; j<a[1].length(); j++)
         {
         for(int k=0; k<a[2].length(); k++)
         {
         aTotal[i*a[1].length()*a[2].length()+ j*a[2].length()+k]=a[0].charAt(i)+""+a[1].charAt(j)+""+a[2].charAt(k)+"";
         }
         }
         }
         for(int i=0; i<b[0].length(); i++)
         {
         for(int j=0; j<b[1].length(); j++)
         {
         for(int k=0; k<b[2].length(); k++)
         {
         bTotal[i*b[1].length()*b[2].length()+ j*b[2].length() +k]=b[0].charAt(i)+""+b[1].charAt(j)+""+b[2].charAt(k)+"";
         }
         }
         }*/
        
        
        out.println(a0.size() * a1.size() * a2.size() + b0.size() * b1.size() * b2.size()-compare(a0,b0)*compare(a1,b1)*compare(a2,b2));
        out.close();
    }
    
    public static void main (String[] args) throws IOException {
        solve();
        System.exit(0);
        
    }
    
}
