/*ID: johnath8
 LANG: JAVA
 TASK: lineup
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class lineup
{
    //use recursion to generate
    static ArrayList<String> poss=new ArrayList<String>();
    public static String exchange4Str(int in)
    {
        String[] temp={"Beatrice", "Belinda", "Bella", "Bessie",  "Betsy", "Blue", "Buttercup", "Sue"};
        return temp[in];
    }
    public static int exchange4Int(String in)
    {
        switch(in){
            case "Beatrice":
                return 0;
            case "Belinda":
                return 1;
            case "Bella":
                return 2;
            case "Bessie":
                return 3;
            case "Betsy":
                return 4;
            case "Blue":
                return 5;
            case "Buttercup":
                return 6;
            case "Sue":
                return 7;
        }
        return -1;
    }
    public static void generate(String curr, String left)
    {
        
        if(left.length()==0)
        {
            String temp=curr.toString();
            poss.add(temp);
        }
        for(int i=0; i<left.length(); i++)
        {
            generate(curr+left.charAt(i), left.replace(left.charAt(i)+"",""));
        }
    }
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f=new BufferedReader(new FileReader(new File("lineup.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
        
        generate("","01234567");
        int num=Integer.parseInt(f.readLine());
        int[][] pairs=new int[num][2];
        ArrayList<String> works=new ArrayList<String>();
        for(int i=0; i<num; i++)
        {
            StringTokenizer st=new StringTokenizer(f.readLine());
            pairs[i][0]=exchange4Int(st.nextToken());
            st.nextToken();
            st.nextToken();
            st.nextToken();
            st.nextToken();
            pairs[i][1]=exchange4Int(st.nextToken());
        }
        /*Prints.declare();
        Prints.printInt(pairs);
        Prints.end();*/
        for(int i=0; i<poss.size(); i++)//current ordering
        {
            
            for(int j=0; j<num; j++)//current condition
            {
                boolean w=false;
                String temp=poss.get(i);
                for(int k=0; k<temp.length()-1; k++)
                {
                    if(temp.substring(k, k+2).equals(Integer.toString(pairs[j][0])+Integer.toString(pairs[j][1])) || 
                       temp.substring(k, k+2).equals(Integer.toString(pairs[j][1])+Integer.toString(pairs[j][0])))
                    {
                        w=true;
                        break;
                    }
                }
                if(!w)
                    break;
                if(j==num-1)
                {
                    for(int a=0; a<temp.length(); a++)
                    {
                        out.println(exchange4Str(Integer.parseInt(temp.charAt(a)+"")));
                        
                    }
                    out.close();
                    System.exit(0);
                }
            }
        }
        works.forEach(System.out::println);
        
        
        
    }
}
