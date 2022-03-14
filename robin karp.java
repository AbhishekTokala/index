import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) throws Exception{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine());
          long[] pow=new long[10006];
                int p=31;
            int m1=1000000000+7;
        pow[0]=31;
         for(int i=1;i<10006;i++){
                pow[i]=((pow[i-1]*p)%m1+m1)%m1;              
            // System.out.println(pow[i]);
            }
        while(t-->0){
            String[] str=br.readLine().split(" ");
            String A=str[1];
            String B=str[0];
            
            long hA=0,hB=0;
          
           
        //    System.out.println(Arrays.toString(pow));
            for(int i=0;i<B.length();i++){
                hA=(hA+((A.charAt(i)-'a'+1)*pow[i])%m1+m1)%m1;
                hB=(hB+((B.charAt(i)-'a'+1)*pow[i])%m1+m1)%m1;
            }
           //  System.out.println(hA+" "+hB);
            int cnt=0;
            int m=B.length();
            if(hA==hB) 
                { 
                cnt+=1;  
                }
            for(int i=B.length();i<A.length();i++){
             //   System.out.println(hA+" "+hB);
                 hA=(hA-((A.charAt(i-m)-'a'+1)*pow[i-m])%m1+((A.charAt(i)-'a'+1)*pow[i])%m1+m1)%m1;   
                 hB=((hB*31)%m1)%m1;
                if(hA==hB) 
                { cnt+=1;  
                }
               
            }
            bw.write(cnt+"\n");
        }
        bw.flush();
    }
}
