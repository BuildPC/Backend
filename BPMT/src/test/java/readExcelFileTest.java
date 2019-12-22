import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class readExcelFileTest {
    static readExcelFile test;

    static Frame frame = new Frame();


    @BeforeAll
    public static void read(){
        String[] arr = new String[1];
        try {
            Frame.main(arr);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public readExcelFileTest(){

    }
    @BeforeAll
    public static void setUpClass(){test = new readExcelFile();}

    @AfterAll
    public static void tearDownClass(){
        test = null;
    }



    @BeforeEach
    void setUp() {
        test = null;

    }

    @AfterEach
    void tearDown() {
        test = null;
    }



    @Test
    public void insertTDBTest(){
        test = new readExcelFile();
        File file = new File("/Users/denis/Desktop/Cs320v2/testimage.jpg");
        test.insertToDB(file);

    }
    @Test
    public void readTest() throws IOException {
        test = new readExcelFile();
        File file = new File("/Users/denis/Desktop/Cs320v2/ItemTable.xlsx");
        test.read(file);
    }
}