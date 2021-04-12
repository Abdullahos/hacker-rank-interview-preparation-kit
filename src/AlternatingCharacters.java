
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AlternatingCharacters {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        //counts of the characters that must be deleted
        int counts= 0;
        //initially current and prev are character at index 0
        char current = s.charAt(0);
        char prev = s.charAt(0);
        //looping over string characters start from character at index 1
        for(int i = 1 ; i < s.length(); i++){
            current = s.charAt(i);
            //if the current character equal the previous one, then there's duplication
            if(current == prev) counts++;
            //make previous the current one
            prev = current;
        }
        return counts;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
