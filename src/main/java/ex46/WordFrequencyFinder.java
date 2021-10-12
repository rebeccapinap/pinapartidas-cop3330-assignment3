package ex46;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Rebecca Pina Partidas
 */

// Libraries
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class WordFrequencyFinder {
    public static void main( String[] args ) throws FileNotFoundException {
        File input = new File("src/main/java/ex46/exercise46_input.txt");
        ArrayList<String> list = new ArrayList<>();

        // Calls function to fill Arraylist with file content
        list = parseFile(input);

        // Calls function that counts frequencies of words and prints list
        countFreq(list);
    }

    static ArrayList<String> parseFile (File input) throws FileNotFoundException {
        Scanner s = new Scanner(input);
        ArrayList<String> list = new ArrayList<String>();

        // Scans in every word in File
        while (s.hasNext())
        {
            list.add(s.next());
        }
        s.close();

        return list;
    }

    static void countFreq(ArrayList<String> list)
    {
        Map<String,Integer> wordFreq = new TreeMap<>();
        Map<String,Integer> newWordFreq = new TreeMap<>();
        String wordArr[]= list.toArray(new String[0]);
        int i;

        for(i = 0; i < wordArr.length; i++)
        {
            // Checks if word is in hashmap
            // If it is add to frequency
            // If it isn't add it to hashmap
            if(wordFreq.containsKey(wordArr[i]))
            {
                wordFreq.put(wordArr[i], wordFreq.get(wordArr[i]) + 1);
            }
            else
            {
                wordFreq.put(wordArr[i], 1);
            }
        }

        // Calls function to sort by frequency
        newWordFreq = sortByFrequency(wordFreq);

        // Output
        for(Map.Entry<String,Integer> entry: newWordFreq.entrySet())
        {
            System.out.print(entry.getKey() + ": ");
            for (i = 0; i < entry.getValue(); i++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static HashMap<String, Integer> sortByFrequency(Map<String, Integer> wordFreq)
    {
        // Make list with content of hashmap
        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(wordFreq.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >()
        {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // Add data from sorted list to new hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();

        for (Map.Entry<String, Integer> newmap : list)
        {
            temp.put(newmap.getKey(), newmap.getValue());
        }
        return temp;
    }
}
