package ex44;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    @Test
    public void checkProduct() throws FileNotFoundException {
        File input = new File("src/test/java/ex44/testfile44.json");
        List<products> list = ProductSearch.scanProducts(input);
        int i;
        String output = "Name: Widget\nPrice: $25.00\nQuantity: 5";

        List<products> productsList = new ArrayList<>();
        productsList.add(new products("Widget", 25.0, 5));
        productsList.add(new products("Thing", 15.0, 5));
        productsList.add(new products("Doodad", 5.0, 10));

        assertEquals(true, list.size() == productsList.size());

        for(i = 0; i < list.size(); i++)
        {
            assertEquals(true, list.get(i).getName().equals(productsList.get(i).getName()));
            assertEquals(true, list.get(i).getPrice() == (productsList.get(i).getPrice()));
            assertEquals(true, list.get(i).getQuantity() == (productsList.get(i).getQuantity()));
        }

        assertEquals(1, ProductSearch.isProduct("Widget", productsList));
        assertEquals(0, ProductSearch.isProduct("This", productsList));
    }
}
