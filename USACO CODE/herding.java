import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class herding
{
    
    //Debug static Printer debug;
    static ArrayList<Integer> cows=new ArrayList<Integer>();
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f=new BufferedReader(new FileReader(new File("herding.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
        Integer N=Integer.parseInt(f.readLine());
        
        for(int i=0; i<N; i++) cows.add(Integer.parseInt(f.readLine()));
        Collections.sort(cows);
        //ArrayList<Integer> indexes=new ArrayList<Integer>();
        int max=0;
        int maxIndex=-1;
            
        for(int i=0; i<cows.size(); i++)
        {
            int counter=0;
            for(int j=i+1; j<cows.size(); j++)
            {
                if(cows.get(i)+N>cows.get(j)) counter++;
                else break;
            }
            //System.out.println(counter);
            if(counter+1>max)
            {
                max=counter+1;
                maxIndex=i;
            }
            else if(counter+1==max && !(cows.get(i+max-1)-cows.get(i)==max-1)) maxIndex=i;
        }
       
        boolean works=false;
        
        if(max==N-1 && (cows.get(1)-cows.get(0)>1 || cows.get(N-1)-cows.get(N-2)>1) && 
           (cows.get(maxIndex+max-1)-cows.get(maxIndex)==max-1)) out.println(2);
        else out.println(N-max);
        out.println(cows.get(N-2)-cows.get(1)-N+Math.max(cows.get(1)-cows.get(0), cows.get(N-1)-cows.get(N-2))+2);
        //System.out.println(cows.get(N-2)+ " " +cows.get(1)+ " " +N+ " " +Math.max(cows.get(1)-cows.get(0), cows.get(N-1)-cows.get(N-2)));
        out.close();
    }
}