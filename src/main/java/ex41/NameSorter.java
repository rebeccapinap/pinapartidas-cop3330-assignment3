package ex41;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Rebecca Pina Partidas
 */

// Libraries
import java.io.*;
import java.util.*;

public class NameSorter {

    public static void main( String[] args ) throws IOException {
        ArrayList<String> nameList = new ArrayList<String>();
        File input = new File("src/main/java/ex41/exercise41_input.txt");

        // Calls function to fill Arraylist with file content
        nameList = scanFile(input);

        // Sorts names in list
        Collections.sort(nameList);

        // Calls function to write Arraylist to file
        writeFile(nameList);
    }

    static ArrayList<String> scanFile (File input) throws FileNotFoundException
    {
        Scanner s = new Scanner(input);
        ArrayList<String> list = new ArrayList<String>();

        // Scans in every line in File
        while (s.hasNextLine())
        {
            list.add(s.nextLine());
        }
        s.close();

        return list;
    }

    static void writeFile (ArrayList<String> list) throws IOException
    {
        FileWriter writer = new FileWriter("src/main/java/ex41/exercise41_output.txt");
        PrintWriter print = new PrintWriter(writer);
        int i;
        int listSize = list.size();

        // Print to file
        print.printf("Total of %d names\n", listSize);
        print.println("-----------------");

        for(i = 0; i < listSize; i++)
        {
            // Print to file
            print.printf("%s" + "%n", list.get(i));
        }

        print.close();
    }
}
