package course.edx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by KH1851 on 11/5/2017.
 */

public class Week1f {
    public static double averageDistBwMidPoints(double a, double b, double c) {
        return (a+b+c)/6;
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
        double result = averageDistBwMidPoints(Double.parseDouble(in[0]), Double.parseDouble(in[1]), Double.parseDouble(in[2]));

        //Write to file
        PrintWriter pw = new PrintWriter("output.txt");
        pw.write(String.valueOf(result));
        pw.close();
    }
}
