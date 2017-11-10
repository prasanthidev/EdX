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

public class Week1d {

    public static void main(String args[]) throws IOException {
        //Read from file
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        List<String> inputs = new ArrayList<>();
        String line = "";
        while((line = br.readLine()) != null){
            inputs.add(line);
        }
        br.close();
        fr.close();
        int N = Integer.parseInt(inputs.get(0));
        String[] theory = inputs.get(1).split(" ");
        String[] practise = inputs.get(2).split(" ");
        int[] t = new int[N];
        int[] p = new int[N];
        int index = 0;
        for(String in:theory) {
            t[index] = Integer.parseInt(in);
            index++;
        } index = 0;
        for(String in:practise) {
            p[index] = Integer.parseInt(in);
            index++;
        }

        // Function call
        int result = findMaxSum(p, t, N);

        //Write to file
        PrintWriter pw = new PrintWriter("output.txt");
        pw.write(String.valueOf(result));
        pw.close();
    }

    private static int findMaxSum(int[] prepare, int[] theory, int N) {
        boolean hasPreparedOnce = false;
        boolean hasTheoryOnce = false;
        int diff = Integer.MAX_VALUE, result = 0;
        for(int i=0; i<N; i++) {
            int delta = prepare[i] - theory[i];
            if(delta >= 0){
                result += prepare[i];
                hasPreparedOnce = true;
            } else {
                result += theory[i];
                hasTheoryOnce = true;
                delta = delta*(-1);
            }
            if(diff > delta) {
                diff = delta;
            }
        }

        if(!(hasPreparedOnce && hasTheoryOnce)){
            result -= diff;
        }

        return result;
    }
}
