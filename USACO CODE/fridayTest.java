/*ID: johnath8
 LANG: JAVA
 TASK: friday
 */
import java.io.*;
import java.util.*;
import java.lang.Math;
import java.util.Scanner;
class fridayTest
{
    public static void main (String [] args) throws IOException
    {
        int[] counter=new int[7];
        int[] leapYearIndex={31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] yearIndex={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int n = 200;
        int dayOfTheWeek=1;
        int dayOfTheMonth=1;
        int month=0;
        int year=0;
        int numberOfDays=(int)(365*(n)-Math.floor(n/4));
        if(n>100)
        {
            numberOfDays+=1;
        }
        for(int i=0; i<numberOfDays; i++)
        {
            dayOfTheMonth+=1;
            dayOfTheWeek=i%7;
            if(month==11 && dayOfTheMonth==31)
            {
                year+=1;
                month=0;
                dayOfTheMonth=1;
                
            }
            if(dayOfTheMonth==13)
            {
                counter[dayOfTheWeek]+=1;
            }
            if(year%4==0 && dayOfTheMonth==leapYearIndex[month])
            {
                dayOfTheMonth=0;
                month+=1;
                
            }
            else if(dayOfTheMonth==yearIndex[month])
            {
                dayOfTheMonth=0;
                month+=1;
                
            }
        }
        for(int i=0; i<7; i++)
        {
            System.out.print(counter[i] + " ");
        }
    }
}
