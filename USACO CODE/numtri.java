/*ID: johnath8
 LANG: JAVA
 TASK: numtri
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class numtri
{
    public static int[] subArray(int[] input, int start, int end)
    {
        int[] output=new int[end-start];
        int counter=0;
        for(int i=start; i<end; i++)
        {
            output[counter]=input[i];
            counter++;
        }
        return output;
    }
    public static void nextRow(int[] received, int[] previousRow, int[] input, int row)
    {
        if(input.length==1)
        {
            received[0]=input[0];
            return;
        }
        
        int[] output=new int[row+1];
        int[] currentRow=subArray(input, row*(row+1)/2, (row+1)*(row+2)/2);
        //System.out.println(Arrays.toString(currentRow));
        for(int i=1; i<row; i++)
        {
            output[i]=Math.max(previousRow[i-1], previousRow[i])+currentRow[i];
        }
        output[0]=previousRow[0]+currentRow[0];
        output[output.length-1]=previousRow[previousRow.length-1]+currentRow[currentRow.length-1];
        //System.out.println(Arrays.toString(output));
        if((row+1)*(row+2)/2<input.length)
            nextRow(received, output, input, row+1);
        else
        {
            for(int i=0; i<output.length; i++)
            {
                received[i]=output[i];
            }
        }
    }
        
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("numtri.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
        int n=Integer.parseInt(f.readLine());
        int[] input=new int[n*(n+1)/2];
        for(int i=0; i<n; i++)
        {
            StringTokenizer line=new StringTokenizer(f.readLine());
            for(int j=0; j<i+1; j++)
            {
                input[i*(i+1)/2+j]=Integer.parseInt(line.nextToken());
            }
        }
        
        int highest=0;
        //System.out.println(Arrays.toString(indicator));
        int[] previousRow=subArray(input, 0, 1);
        int[] output=new int[n];
        nextRow(output, previousRow, input, 1);
        //System.out.println(Arrays.toString(output));
        for(int i=0; i<n; i++)
        {
            highest=Math.max(output[i], highest);
        }
        
        out.println(highest);
        out.close();
    }
}
