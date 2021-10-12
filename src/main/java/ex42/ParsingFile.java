package ex42;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Rebecca Pina Partidas
 */

// Libraries
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ParsingFile {
    public static void main( String[] args ) throws FileNotFoundException {
        File input = new File("src/main/java/ex42/exercise42_input.txt");
        ArrayList<String[]> list = new ArrayList<>();

        // Parses file to plug into list
        list = parseFile(input);

        // Calls function that prints list
        printList(list);
    }

    static ArrayList<String[]> parseFile (File input) throws FileNotFoundException {
        Scanner s = new Scanner(input);
        ArrayList<String[]> list = new ArrayList<>();
        String temp;
        String[] indivInput;

        // Scans in words separated by commas
        while (s.hasNextLine())
        {
            temp = s.nextLine();
            indivInput = temp.split(",", 3);
            list.add(indivInput);
        }

        s.close();

        return list;
    }

    static void printList(ArrayList<String[]> list)
    {
        int i;
        int listSize = list.size();

        // Ouput
        System.out.println("Last      First     Salary");
        System.out.println("--------------------------");

        for(i = 0; i < listSize; i++)
        {
            System.out.printf("%-10s%-10s%-10s\n", list.get(i)[0], list.get(i)[1], list.get(i)[2]);
        }
    }
}
