
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockAndValidString {

    // Complete the isValid function below.
    static String isValid(String s) {
        HashMap<Character,Integer> letterFreqs = new HashMap<Character,Integer>(); 
        for(int i = 0 ; i < s.length(); i++){
            //if map contains that letter, increment the frequency of that letter
            if(letterFreqs.containsKey(s.charAt(i))){
                int freq = letterFreqs.get(s.charAt(i));
                freq++;
                letterFreqs.put(s.charAt(i),freq);
            }
            //if map doesn't contain that letter, put its frequency as 1
            else{
                letterFreqs.put(s.charAt(i),1);
            }
        }
        //arr to store the letter's frequencies
        int arr[] = new int[letterFreqs.size()];
        int i = 0;
        for(char ch : letterFreqs.keySet()){
            //load freqs
            arr[i] = letterFreqs.get(ch);
            i++;
        }
        
        //sort ascending the frequencies(occurrences of the letters for make it more logical to make analysis)
        Arrays.sort(arr);
        
        int NoOfAvailableTrial = 1;
        int prev = arr[0];
        int current = arr[0];
        
        for( i = 1; i<arr.length; i++){
            current = arr[i];
            //not equal
            if(current!=prev){
                //first try to remove 1 letter
               if( NoOfAvailableTrial == 1){
                   //difference is more than 1 and the previous != 1  so we can't remove the prev
                   if(current-prev>1 &&  prev!=1)   return "NO";
                   //if the current is at index 1 so, it's the first time and hopefully the firstlast time to remove one letter
                   if( i == 1)  {
                       NoOfAvailableTrial--;
                   }
                   //if it happens at the last elem and the last elem(letter's freq == 1) we can delete it and there's no more deletion for sure(end of array)so, return YES
                   else if(i == arr.length-1 && current==1)    return "YES";
                   //if it happens at any other index or current!=1 so can't be deleted
                   else return "NO";
               }
               //no more chances
               else return "NO";
            }            
            prev = current;
        }
        return "YES";
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
