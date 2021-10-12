package ex45;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Rebecca Pina Partidas
 */

// Libraries
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WordFinder {
    public static void main( String[] args ) throws IOException {
        String inputStr;
        String newinputStr;
        File input = new File("src/main/java/ex45/exercise45_input.txt");

        // Call function to fill string with file content
        inputStr = scanFile(input);

        // Call function to fill new string with edited old string
        newinputStr = replace(inputStr);

        // Call function to write string to file
        writeFile(newinputStr);
    }

    static String scanFile (File input) throws FileNotFoundException
    {
        Scanner s = new Scanner(input);
        ArrayList<String> list = new ArrayList<String>();
        String content = "";
        int i;

        // Scans in every line in File
        while (s.hasNextLine())
        {
            list.add(s.nextLine());
        }
        s.close();

        // Makes Arraylist into string
        for (i = 0; i < list.size(); i++)
        {
            content += list.get(i);
            content += "\n";
        }

        return content;
    }

    static String replace (String inputStr)
    {
        // Replaces every instance of utilize in string with use
        String newinputStr = inputStr.replaceAll("utilize", "use");

        return newinputStr;
    }

    static void writeFile (String outputStr) throws IOException {
        Scanner input = new Scanner(System.in);

        // Asks for what file name should be
        System.out.print("Output file name: ");
        String fileName = input.nextLine();

        String fullFile = "src/main/java/ex45/" + fileName;

        FileWriter writer = new FileWriter(fullFile);
        PrintWriter print = new PrintWriter(writer);

        // Prints string to file
        print.print(outputStr);

        print.close();
    }
}
