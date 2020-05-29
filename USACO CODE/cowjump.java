import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class cowjump
{
    
    //Debug static Printer debug;
    static ArrayList<Seg> fences=new ArrayList<Seg>();
    public static int[] find()
    {
        
        int[] out=new int[2];
        ArrayList<Seg> active=new ArrayList<Seg>();
        for(int i=0; i<fences.size(); i++)
        {
            //System.out.println("i: " + i);
            for(int j=0; j<active.size(); j++)
            {
                if(fences.get(i).inter(active.get(j))) 
                {
                    out[0]=i;
                    out[1]=active.get(j).id2;
                    //System.out.println(out[0] + " "+ out[1]);
                    return out;
                }
                
            }
            active.add(fences.get(i));
            ArrayList<Seg> gone=new ArrayList<Seg>();
            
            for(int j=0; j<active.size(); j++)
            {
                
                if(Math.max(active.get(j).x1, active.get(j).x2)<Math.min(fences.get(i).x1, fences.get(i).x2)) gone.add(active.remove(0));
                else break;
            }
            //System.out.println(gone.size());
            for(Seg s1:gone)
            {
                for(Seg s2:active)
                {
                    if(s1.inter(s2))
                    {
                        out[0]=s1.id2;
                        out[1]=s2.id2;
                        //System.out.println(out[0] + " "+ out[1]);
                        return out;
                    }
                }
            }
        }
        return out;
    }
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f=new BufferedReader(new FileReader(new File("cowjump.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        int N=Integer.parseInt(f.readLine());
        for(int i=0; i<N; i++)
        {
            StringTokenizer segSt=new StringTokenizer(f.readLine());
            fences.add(new Seg(Integer.parseInt(segSt.nextToken()), Integer.parseInt(segSt.nextToken()), 
                               Integer.parseInt(segSt.nextToken()), Integer.parseInt(segSt.nextToken()), i, 0));
        }
        Collections.sort(fences);
        for(int i=0; i<fences.size(); i++) fences.get(i).id2=i;
        int[] ans=find();
        int temp=0;
        if(ans[0]>ans[1])
        {
            temp=ans[0];
            ans[0]=ans[1];
            ans[1]=temp;
        }
        int count=0;
        for(int i=0; i<fences.size(); i++)
        {
            if(i==ans[0] || i==ans[1]) continue;
            if(fences.get(ans[1]).inter(fences.get(i)))
            {
                count++;
                break;
            }
        }
        if(count>0) out.println(fences.get(ans[1]).id1+1);
        else out.println(fences.get(ans[0]).id1+1);
        out.close();
    }
}
class Seg implements Comparable<Seg>
{
    public int x1;
    public int y1;
    public int x2;
    public int y2;
    public int id1;
    public int id2;
    public Seg(int x1, int y1, int x2, int y2, int id1, int id2)
    {
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        this.id1=id1;
        this.id2=id2;
    }
    static boolean onSegment(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        return (x2 <= Math.max(x1, x3) && x2 >= Math.min(x1, x3) && 
                y2 <= Math.max(y1, y3) && y2 >= Math.min(y1, y3));
    }
    static int orientation(int x1, int y1, int x2, int y2, int x3, int y3) 
    {
        int val = (y2 - y1) * (x3 - x2) - 
            (x2 - x1) * (y3 - y2); 
        if (val == 0) return 0;
        return (val > 0)? 1: 2;
    }
    public boolean inter(Seg o) 
    {
        
        int o1 = orientation(this.x1, this.y1, this.x2, this.y2, o.x1, o.y1);
        int o2 = orientation(this.x1, this.y1, this.x2, this.y2, o.x2, o.y2);
        int o3 = orientation(o.x1, o.y1, o.x2, o.y2, this.x1, this.y1);
        int o4 = orientation(o.x1, o.y1, o.x2, o.y2, this.x2, this.y2);
        if (o1 != o2 && o3 != o4) return true; 
        if (o1 == 0 && onSegment(this.x1, this.y1, o.x1, o.y1, this.x2, this.y2)) return true; 
        if (o2 == 0 && onSegment(this.x1, this.y1, o.x2, o.y2, this.x2, this.y2)) return true; 
        if (o3 == 0 && onSegment(o.x1, o.y1, this.x1, this.y1, o.x2, o.y2)) return true;
        if (o4 == 0 && onSegment(o.x1, o.y1, this.x2, this.y2, o.x2, o.y2)) return true; 
        return false;
    }
    public int compareTo(Seg o)
    {
        return Math.min(this.x1, this.x2)-Math.min(o.x1, o.x2);
    }
}