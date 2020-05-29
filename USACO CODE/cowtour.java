/*ID: johnath8
 LANG: JAVA
 TASK: cowtour
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class cowtour
{
    static double[][] map;
    static double[] maxd;
    static ArrayList<Point> points=new ArrayList<Point>();
    public static void solve() throws Exception
    {
        BufferedReader f = new BufferedReader(new FileReader("cowtour.in"));
        PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("cowtour.out")));
        int n=Integer.parseInt(f.readLine());
        
        map=new double[n][n];
        
        for(int i=0; i<n; i++)
        {
            StringTokenizer st=new StringTokenizer(f.readLine());
            Point p=new Point(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));
            points.add(p);
        }
        //points.forEach(System.out::print);
        for(int i=0; i<n; i++)
        {
            String temp=f.readLine();
            for(int j=0; j<n; j++)
            {
                double in=Double.parseDouble(temp.charAt(j)+"");
                if(i==j)
                    map[i][j]=0;
                else if(in==0)
                    map[i][j]=Double.MAX_VALUE;
                else
                    map[i][j]=points.get(i).dist(points.get(j));
                
            }
        }
        for(int k=0; k<n; k++)
        {
            for(int i=0; i<n; i++)
            {
                for(int j=0; j<n; j++)
                {
                    if(map[i][k]!=Double.MAX_VALUE && map[k][j]!=Double.MAX_VALUE)
                        map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]);
                }
            }
        }
        double[] maxd=new double[n];
        double max1=0;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(map[i][j]!=Double.MAX_VALUE)
                {
                    maxd[i]=Math.max(map[i][j], maxd[i]);
                    max1=Math.max(max1, maxd[i]);
                }
            }
        }
        double max2 = Double.MAX_VALUE;
        for (int i=0; i<n; i++) 
        {
            for (int j=0; j<n; j++) 
            {
                if(map[i][j]==Double.MAX_VALUE) 
                {
                    max2=Math.min(max2, maxd[i] + maxd[j]
                                      + points.get(i).dist(points.get(j)));
                }
            }
        }
        out.write(String.format("%.6f", Math.max(max1, max2))+"\n");
        out.close();
    }
    
    public static void main(String[] args) throws Exception
    {
        solve();
        System.exit(0);
    }
}
class Point
{
    public double x;
    public double y;
    public double dist(Point in)
    {
        return Math.sqrt((in.x-x)*(in.x-x)+(in.y-y)*(in.y-y));
    }
    public Point(double a, double b)
    {
        this.x=a;
        this.y=b;
    }
}
