package ex43;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Rebecca Pina Partidas
 */

// Libraries
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class WebsiteGenerator {
    public static void main( String[] args ) throws IOException {
        Scanner input = new Scanner(System.in);

        // Asks for user input
        System.out.print("Site name: ");
        String siteName = input.nextLine();

        System.out.print("Author: ");
        String author = input.nextLine();

        System.out.print("Do you want a folder for JavaScript? ");
        String javaScript = input.nextLine();

        System.out.print("Do you want a folder for CSS? ");
        String css = input.nextLine();

        // Makes files using information from user input
        makeAllFiles(siteName, author, javaScript, css);
    }

    static void makeAllFiles(String siteName, String author, String javaScript, String css) throws IOException
    {
        // Setting strings for simplification of directories for creating files
        String websiteDirec = "src/main/java/ex43/website";
        String siteDirec = "src/main/java/ex43/website/" + siteName;
        String webDirecShort = "./website/" + siteName;
        String indexDirec = "/index.html";
        String javaDirec = "/js/";
        String cssDirec = "/css/";
        String javaFullDirec = siteDirec + javaDirec;
        String cssFullDirec = siteDirec + cssDirec;

        new File(websiteDirec).mkdirs();
        new File(siteDirec).mkdirs();

        System.out.println("Created " + webDirecShort);

        // Makes index.html file and writes html code in it
        makeFile(webDirecShort, siteDirec, indexDirec);
        makeHTML(siteName, author, siteDirec, indexDirec);

        // Creates java script file directory
        if (javaScript.equals("y"))
        {
            new File(javaFullDirec).mkdirs();
            System.out.println("Created " + webDirecShort + javaDirec);
        }

        // Creates css file directory
        if (css.equals("y"))
        {
            new File(cssFullDirec).mkdirs();
            System.out.println("Created " + webDirecShort + cssDirec);
        }
    }

    static void makeFile(String webDirecShort, String siteDirec, String inputDirec) throws IOException
    {
        String fileDirec = siteDirec + inputDirec;
        File newFile = new File(fileDirec);

        newFile.createNewFile();

        System.out.println("Created " + webDirecShort + inputDirec);
    }

    static void makeHTML(String siteName, String author, String siteDirec, String indexDirec) throws IOException
    {
        String indexFullDirec = siteDirec + indexDirec;
        FileWriter writer = new FileWriter(indexFullDirec);
        PrintWriter print = new PrintWriter(writer);

        // Inputs html information using user input
        print.println("<!DOCTYPE html>");
        print.println("<html>");
        print.println("<head>");
        print.println("\t<title>" + siteName + "</title>");
        print.println("\t<meta name = \"author\" content = \"" + author + "\">");
        print.println("</head>");
        print.println("</html>");

        print.close();
    }
}
