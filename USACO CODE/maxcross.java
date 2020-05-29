import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class maxcross
{
    static int N;
    static int K;
    static int B;
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f=new BufferedReader(new FileReader(new File("maxcross.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));
        StringTokenizer st=new StringTokenizer(f.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        B=Integer.parseInt(st.nextToken());
        ArrayList<Integer> broken=new ArrayList<Integer>();
        broken.add(0);
        for(int i=0; i<B; i++) broken.add(Integer.parseInt(f.readLine()));
        Collections.sort(broken);
        int ans=100000;
        for(int i=0; i<B+1; i++)
        {
            int currAns=0;
            int curr=broken.get(i);
            if(curr+K>N)
                break;
            for(int j=i+1; j<broken.size(); j++)
            {
                
                if(curr+K>=broken.get(j))
                {
                    currAns++;
                }
                else break;                    
            }
            //System.out.println(curr+ " "+currAns);
            ans=Math.min(currAns, ans);
        }
        out.println(ans);
        out.close();
    }
}
