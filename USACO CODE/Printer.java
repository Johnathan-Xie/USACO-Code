import java.io.*;
import java.util.*;
import java.lang.Math;

class Printer
{
    static PrintWriter debug;
    public Printer(String in) throws IOException
    {
        debug=new PrintWriter(new BufferedWriter(new FileWriter(in)));
    }
    public void printInt(int[][] in) throws IOException
    {
       
        int maxLength=0;
        for(int i=0; i<in.length; i++)
        {
            for(int j=0; j<in[0].length; j++)
            {
                maxLength=Math.max((Integer.toString(in[i][j])).length(), maxLength);
            }
        }
        for(int i=0; i<in.length; i++)
        {
            for(int j=0; j<in[0].length; j++)
            {
                String print=Integer.toString(in[i][j]);
                while(print.length()<maxLength)
                    print=print+" ";
                debug.print(print+" ");
            }
            debug.print("\n");
        }
        debug.print("\n");
    }
    public void printLong(long[][] in) throws IOException
    {
        
        int maxLength=0;
        for(int i=0; i<in.length; i++)
        {
            for(int j=0; j<in[0].length; j++)
            {
                maxLength=Math.max((Long.toString(in[i][j])).length(), maxLength);
            }
        }
        for(int i=0; i<in.length; i++)
        {
            for(int j=0; j<in[0].length; j++)
            {
                String print=Long.toString(in[i][j]);
                while(print.length()<maxLength)
                    print=print+" ";
                debug.print(print+" ");
            }
            debug.print("\n");
        }
        debug.print("\n");
    }
    public void printChar(char[][] in) throws IOException
    {
        
        int maxLength=0;
        for(int i=0; i<in.length; i++)
        {
            for(int j=0; j<in[0].length; j++)
            {
                maxLength=Math.max((in[i][j]+"").length(), maxLength);
            }
        }
        for(int i=0; i<in.length; i++)
        {
            for(int j=0; j<in[0].length; j++)
            {
                String print=in[i][j]+"";
                while(print.length()<maxLength)
                    print=print+" ";
                debug.print(print+" ");
            }
            debug.print("\n");
        }
        debug.print("\n");
    }
    public void printBoolean(boolean[][] in) throws IOException
    {
        for(int i=0; i<in.length; i++)
        {
            for(int j=0; j<in[0].length; j++)
            {
                if(in[i][j])
                {
                    debug.print("*");
                }
                else
                    debug.print("-");
            }
            debug.print("\n");
        }
        debug.print("\n");
    }
    public void printString(String[][] in) throws IOException
    {
        
        int maxLength=0;
        for(int i=0; i<in.length; i++)
        {
            for(int j=0; j<in[0].length; j++)
            {
                maxLength=Math.max(in[i][j].length(), maxLength);
            }
        }
        for(int i=0; i<in.length; i++)
        {
            for(int j=0; j<in[0].length; j++)
            {
                String print=in[i][j];
                while(print.length()<maxLength)
                    print=print+" ";
                debug.print(print+" ");
            }
            debug.print("\n");
        }
        debug.print("\n");
    }
    
    public void close()
    {
        debug.close();
    }
    
}


