package course.edx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by KH1851 on 11/5/2017.
 */

public class Week1c {

    public static int threeFibonacci(int a0, int a1, int a2, int N) {
        if(N == 0)
            return a0;
        if(N == 1)
            return a1;
        if(N == 2)
            return a2;

        int res = 0;
        for(int i=0; i<(N-2); i++) {
            res = a2 + a1 - a0;
            a0 = a1; a1 = a2; a2 = res;
        }

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
        long result = threeFibonacci(Integer.parseInt(in[0]), Integer.parseInt(in[1]), Integer.parseInt(in[2]), Integer.parseInt(in[3]));

        //Write to file
        PrintWriter pw = new PrintWriter("output.txt");
        pw.write(String.valueOf(result));
        pw.close();
    }
}
