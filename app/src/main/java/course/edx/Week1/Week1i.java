package course.edx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by KH1851 on 11/6/2017.
 */

public class Week1i {
    public static int maxProblemsSolved(int N, int[] a) {
        int timeSpan = 18000;

        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                if(a[i] > a[j]) {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }

        int noOfPrograms = 0;
        int result = 0;
        for(int i=0; i<N; i++){
            if((result + a[i]) > timeSpan)
                break;
            result += a[i];
            noOfPrograms+=1;
        }

        return noOfPrograms;
    }

    public static void main(String args[]) throws IOException {
        //Read from file
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        int N = Integer.parseInt(br.readLine());
        String line = br.readLine();
        br.close();
        fr.close();
        String[] input = line.split(" ");
        int[] p1 = new int[N];
        int index = 0;
        for(String in:input) {
            p1[index] = Integer.parseInt(in);
            index++;
        }

        // Function call
        int result = maxProblemsSolved(N, p1);

        //Write to file
        PrintWriter pw = new PrintWriter("output.txt");
        pw.write(String.valueOf(result));
        pw.close();
    }
}
