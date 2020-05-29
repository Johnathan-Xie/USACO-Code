import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class triangles
{
    static int N;
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f=new BufferedReader(new FileReader(new File("triangles.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
        N=Integer.parseInt(f.readLine());
        ArrayList<Integer> xPoints=new ArrayList<Integer>();
        ArrayList<Integer> yPoints=new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> x=new ArrayList<>();
        ArrayList<ArrayList<Integer>> y=new ArrayList<>();
        ArrayList<ArrayList<Integer>> xDist=new ArrayList<>();
        ArrayList<ArrayList<Integer>> yDist=new ArrayList<>();
        for(int i=0; i<20000; i++)
        {
            x.add(new ArrayList<Integer>());
            y.add(new ArrayList<Integer>());
            xDist.add(new ArrayList<Integer>());
            yDist.add(new ArrayList<Integer>());
        }
        for(int i=0; i<N; i++)
        {
            StringTokenizer pointSt=new StringTokenizer(f.readLine());
            int xTemp=Integer.parseInt(pointSt.nextToken())+10000;
            int yTemp=Integer.parseInt(pointSt.nextToken())+10000;
            x.get(xTemp).add(yTemp);
            y.get(yTemp).add(xTemp);
            xPoints.add(xTemp);
            yPoints.add(yTemp);
        }
        
        for(int i=0; i<20000; i++)
        {
            Collections.sort(x.get(i));
            Collections.sort(y.get(i));
        }
        for(int i=0; i<20000; i++)
        {
            if(x.get(i).size()==0)
                continue;
            int firstDist=0;
            for(int j=1; j<x.get(i).size(); j++) firstDist+=(x.get(i).get(j)-x.get(i).get(0));
            xDist.get(i).add(firstDist);
            for(int j=1; j<x.get(i).size(); j++)
            {
                int diff=x.get(i).get(j)-x.get(i).get(j-1);
                xDist.get(i).add(xDist.get(i).get(xDist.get(i).size()-1)+(j-1)*diff-(x.get(i).size()-1-j)*diff);
            }
        }
        for(int i=0; i<20000; i++)
        {
            if(y.get(i).size()==0)
                continue;
            int firstDist=0;
            for(int j=1; j<y.get(i).size(); j++) firstDist+=(y.get(i).get(j)-y.get(i).get(0));
            yDist.get(i).add(firstDist);
            for(int j=1; j<y.get(i).size(); j++)
            {
                int diff=y.get(i).get(j)-y.get(i).get(j-1);
                yDist.get(i).add(yDist.get(i).get(yDist.get(i).size()-1)+(j-1)*diff-(y.get(i).size()-1-j)*diff);
            }
        }
        int total=0;
        for(int i=0; i<N; i++)
        {
            
            long add=(long)(xDist.get(xPoints.get(i)).get(x.get(xPoints.get(i)).indexOf(yPoints.get(i))))*
                     (long)(yDist.get(yPoints.get(i)).get(y.get(yPoints.get(i)).indexOf(xPoints.get(i))));
            total+=(add);
            total=total%1000000007;
        }
        out.println(total);
        out.close();
    }
}
