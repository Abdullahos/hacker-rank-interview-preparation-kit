
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class StringMakingAnagrams {

    static int makeAnagram(String a, String b) {
        HashMap<Character,Integer> first = new HashMap<Character,Integer>();
        HashMap<Character,Integer> sec = new HashMap<Character,Integer>();
        
        for(int i = 0; i<a.length(); i++){
            if(first.containsKey(a.charAt(i))){
                int freq = first.get(a.charAt(i));
                freq++;
                first.put(a.charAt(i),freq);
            }
            else{
                first.put(a.charAt(i),1);
            }
        }
        for(int i = 0; i<b.length(); i++){
            if(sec.containsKey(b.charAt(i))){
                int freq = sec.get(b.charAt(i));
                freq++;
                sec.put(b.charAt(i),freq);
            }
            else{
                sec.put(b.charAt(i),1);
            }
        }
        HashMap <Character, Integer> common = new HashMap <Character, Integer>();
        //searching for the common   
        int commonCounts = 0;    
        for(char ch:first.keySet()){
            if(sec.containsKey(ch)){
                int firstFreq = first.get(ch);
                int secFreq = sec.get(ch); 
                if(firstFreq <= secFreq)    {
                    common.put(ch,firstFreq); 
                    commonCounts =commonCounts+firstFreq;
                }
                else{
                    common.put(ch,secFreq);
                    commonCounts = commonCounts+secFreq;
                }
            }
        }
        return a.length()+b.length()-2*commonCounts;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
