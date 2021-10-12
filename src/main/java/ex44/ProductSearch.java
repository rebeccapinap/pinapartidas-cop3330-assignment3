package ex44;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Rebecca Pina Partidas
 */

//Libraries
import java.io.FileNotFoundException;
import java.io.*;
import java.util.*;
import com.google.gson.*;

public class ProductSearch {
    public static void main( String[] args ) throws FileNotFoundException {
        File input = new File("src/main/java/ex44/exercise44_input.json");
        List<products> productsList;
        String product;

        // Calls method that fills product list with file content
        productsList = scanProducts(input);

        // Calls method that searches for product, finds it, and outputs its information
        product = search(productsList);

        // Output
        System.out.println(product);
    }

    static List<products> scanProducts (File input) throws FileNotFoundException {
        List<products> productsList = new ArrayList<>();
        JsonElement element = JsonParser.parseReader(new FileReader(input));
        JsonObject object = element.getAsJsonObject();
        JsonArray array = object.get("products").getAsJsonArray();
        JsonObject productsObject;
        String name = "";
        double price = 0;
        int quantity = 0;

        // Reads every object into class
        for (JsonElement productJson : array)
        {
             productsObject = productJson.getAsJsonObject();
             name = productsObject.get("name").getAsString();
             price = productsObject.get("price").getAsDouble();
             quantity = productsObject.get("quantity").getAsInt();

             products newProduct = new products(name, price, quantity);
             productsList.add(newProduct);
        }

        return productsList;
    }

    static String search (List<products> productsList)
    {
        Scanner input = new Scanner(System.in);
        int isProduct = 0;
        String name = "";
        double price = 0;
        int quantity = 0;
        String output = "";

        // While loop that asks for product name and if product is found fills output string
        while(isProduct == 0)
        {
            // Asks for user input
            System.out.print("What is the product name? ");
            String productName = input.nextLine();

            // Calls function to check if product name exists in objects
            // Assigns 1 if input product name exists in objects
            // Assigns 0 if input product name does not exist in objects
            isProduct = isProduct(productName, productsList);

            if (isProduct == 0)
            {
                // Output if product not in objects
                System.out.println("Sorry, that product was not found in our inventory.");
            }
            else if (isProduct == 1)
            {
                // Sets variables of product in order to fill output string
                for (products a: productsList)
                {
                    if (a.getName().equals(productName))
                    {
                        name = a.getName();
                        price = a.getPrice();
                        quantity = a.getQuantity();
                        break;
                    }
                }
                output = String.format("Name: %s\nPrice: $%.2f\nQuantity: %d", name, price, quantity);
            }

        }

        return output;
    }

    static int isProduct(String productName, List<products> productsList)
    {
        // Checks if product name exists in any object
        for (products a: productsList)
        {
            if(a.getName().equals(productName))
                return 1;
        }

        return 0;
    }
}

class products
{
    private String name;
    private double price;
    private int quantity;

   public products (String name, double price, int quantity)
   {
       this.name = name;
       this.price = price;
       this.quantity = quantity;
   }

    public String getName()
    {
        return name;
    }
    public double getPrice()
    {
        return price;
    }
    public int getQuantity()
    {
        return quantity;
    }
}
