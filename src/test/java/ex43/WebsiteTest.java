package ex43;

import org.junit.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class WebsiteTest {
    @Test
    public void checkWebsite()
    {
        File websiteDirec = new File("src/main/java/ex43/website");
        assertEquals(true, websiteDirec.exists());

        File siteDirec = new File("src/main/java/ex43/website/awesomeco");
        assertEquals(true, siteDirec.exists());

        File indexFile = new File("src/main/java/ex43/website/awesomeco/index.html");
        assertEquals(true, indexFile.exists());

        File javaDirec = new File("src/main/java/ex43/website/awesomeco/js");
        assertEquals(true, javaDirec.exists());

        File cssDirec = new File("src/main/java/ex43/website/awesomeco/css");
        assertEquals(true, cssDirec.exists());
    }
}

