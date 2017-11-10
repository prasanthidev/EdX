package course.edx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KH1851 on 11/5/2017.
 */

public class Week1b {
    public static long getSum(long a, long b) {
        long res = a + (b*b);
        return res;
    }

    public static void main(String args[]) throws IOException {
        //Read from file
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        br.close();
        fr.close();
        String[] in = line.split(" ");

        // Function call
        long result = getSum(Long.parseLong(in[0]), Long.parseLong(in[1]));

        //Write to file
        PrintWriter pw = new PrintWriter("output.txt");
        pw.write(String.valueOf(result));
        pw.close();
    }
}
