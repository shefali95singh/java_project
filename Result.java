import java.io.*;
//import java.math.*;
//import java.security.*;
//import java.text.*;
import java.util.*;
//import java.util.concurrent.*;
//import java.util.function.*;
//import java.util.regex.*;
import java.util.stream.*;
//import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        //String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        //int n = Integer.parseInt(firstMultipleInput[0]);

        //int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        System.out.println(total);

        bufferedReader.close();
    }


    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
    int i = 0;
    int hcf = 0;
    int lcm = 1;
    int num = 0;
    for(i=0; i<b.size(); i++)
    {
        hcf = h_c_f(hcf, b.get(i));
    }
    System.out.println("HCF = "+hcf);
    for(i=0; i<a.size(); i++)
    {
        lcm = l_c_m(lcm, a.get(i));
    }
    System.out.println("LCM = "+lcm);
    if(hcf%lcm!=0) //hcf = 24 lcm = 12
        return 0;
    else{
        
        for(i=lcm; i<=hcf; i++)//12 to <24
        {
           // System.out.println(i+"    "+num);
            if(i%lcm == 0 && hcf%i==0)
                num++;
        }
        return num;
    }
    
    }
    static int l_c_m(int a, int b)
    {
        int lcm = ((a)/(h_c_f(a,b)))*b;
        return lcm;
    }
    static int h_c_f(int a, int b)
    {
        while(a>0 && b>0)
        {
            if(a>=b)
                a = a%b;
            else if(b>=a)
                b = b%a;
        }
        return (a+b);
    }

}