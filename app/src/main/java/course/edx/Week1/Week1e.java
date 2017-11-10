package course.edx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by KH1851 on 11/5/2017.
 */

public class Week1e {
    private static int max_sum = 0;

    public static void distributeRole(int[][] input, List<Integer> indices, int personIndex, int sum) {
        if(indices.size() == 0 || personIndex == 3) {
            if(sum > max_sum)
                max_sum = sum;
            return;
        }

        for(int index:indices) {
            List<Integer> newIndices = new ArrayList<>();
            newIndices.addAll(indices);
            newIndices.remove((Object)index);
            distributeRole(input, newIndices, personIndex+1, sum + (input[personIndex][index]*input[personIndex][index]));
        }
    }

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
        String[] person1 = inputs.get(0).split(" ");
        String[] person2 = inputs.get(1).split(" ");
        String[] person3 = inputs.get(2).split(" ");
        int[] p1 = new int[3];
        int[] p2 = new int[3];
        int[] p3 = new int[3];
        int index = 0;
        for(String in:person1) {
            p1[index] = Integer.parseInt(in);
            index++;
        } index = 0;
        for(String in:person2) {
            p2[index] = Integer.parseInt(in);
            index++;
        } index = 0;
        for(String in:person3) {
            p3[index] = Integer.parseInt(in);
            index++;
        }

        int sum = 0;
        int[][] input = new int[][]{p1, p2, p3};
        // Function call
        distributeRole(input, Arrays.asList(0,1,2), 0, sum);

        //Write to file
        PrintWriter pw = new PrintWriter("output.txt");
        pw.write(String.valueOf(Math.sqrt(max_sum)));
        pw.close();
    }
}
