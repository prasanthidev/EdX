package course.edx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by KH1851 on 11/5/2017.
 */

public class Week1g {
    public static List<String> codeTemplate(char[][] keyboard, ArrayList<StringBuffer> codeTemplates,
                                                 ArrayList<String> languages, int M, int N) {

        // Hash the keyboard
        HashMap<Character, List<Integer>> keys = new HashMap<>();
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                keys.put(keyboard[i][j], Arrays.asList(j+1, M-i));
            }
        }

        int n = codeTemplates.size();
        int[] dist = new int[n];
        int index = 0;

        for(StringBuffer template: codeTemplates) {
            int prevX = keys.get(template.charAt(0)).get(0);
            int prevY = keys.get(template.charAt(0)).get(1);
            int curX = 0, curY = 0;
            int distance = 0;

            for(int i=1; i<template.length(); i++) {
                if(template.charAt(i) == ' ')
                    continue;
                curX = keys.get(template.charAt(i)).get(0);
                curY = keys.get(template.charAt(i)).get(1);

                // Calculate max(|XA−XB|,|YA−YB|)
                distance += Math.max(Math.abs(prevX - curX), Math.abs(prevY - curY));
                prevX = curX; prevY = curY;
            }

            dist[index] = distance;
            index++;
        }

        int shortestDist = Integer.MAX_VALUE;
        index = 0;
        for(int i=0; i<n; i++) {
            if(shortestDist > dist[i]) {
                shortestDist = dist[i];
                index = i;
            }
        }

        List<String> result = Arrays.asList(String.valueOf(shortestDist), languages.get(index));
        return result;
    }

    public static void main(String args[]) throws IOException {
        //Read from file
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);

        // Read Keyboard
        String[] coords = br.readLine().split(" ");
        int N = Integer.parseInt(coords[0]);
        int M = Integer.parseInt(coords[1]);
        char[][] keyboard = new char[M][N];
        int c = 0;
        for(int m = 0; m<M; m++) {
            for (int n = 0; n<N; n++) {
                char ch = (char) br.read();
                keyboard[m][n] = ch;
            }
            br.read(); br.read();
        }

        // Read code and language
        String line = "";
        ArrayList<StringBuffer> codeTemplates = new ArrayList<>();
        ArrayList<String> languages = new ArrayList<>();
        boolean isCodeStart = false;
        StringBuffer code = null;
        while((line = br.readLine()) != null){
            if(line.matches("%TEMPLATE-START%")) {
                isCodeStart = true;
                code = new StringBuffer();
                continue;
            }
            if(line.matches("%TEMPLATE-END%")) {
                isCodeStart = false;
                codeTemplates.add(code);
                continue;
            }
            if(isCodeStart) {
                line = line.replaceAll("\\s","");
                code.append(line);
            } else {
                languages.add(line);
            }
        }
        br.close();
        fr.close();

        // Function call
        List<String> bestCode = codeTemplate(keyboard, codeTemplates, languages, M, N);

        //Write to file
        PrintWriter pw = new PrintWriter("output.txt");
        pw.write(bestCode.get(1) +"\n" + bestCode.get(0));
        pw.close();
    }
}
