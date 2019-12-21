import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SQLUtilitiesTest {
    static Frame frame = new Frame();
    static SQLUtilities test;

    @BeforeAll
    public static void setUpClass(){
        String[] arr = new String[1];
        try {
            Frame.main(arr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        test = new SQLUtilities();
    }

    @AfterAll
    public static void tearDownClass(){
    }



    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void currenid() {
        test.currenid(frame.conn);
    }

    @Test
    void getItemData() {
        test.getItemData(frame.conn,"GIGABYTE B365M");

    }
    @Test
    void UpdateStock(){
        test.UpdateStock("GIGABYTE B365M",2223,4445,frame.conn);
    }
    @Test
    void UpdateStock1(){
        test.UpdateStock("testvalue1",2223,2222,frame.conn);
    }


    @Test
    void AddItem() throws SQLException {
        test.AddItem("asdfga","asgfg",1,2.3f,1,frame.conn,"blob");
    }


    @Test
    void getusersData(){
        test.getUserData(frame.conn,"ozpu92@gmail.com");
    }


    @Test
    void uploaimage() throws IOException {
        ArrayList<String> a = new ArrayList<String>();
        ArrayList<ArrayList<String>> b = new ArrayList<>();
        a.add("asdfsadf,2222,wefa,asfdsa,/Users/denis/Desktop/Cs320v2/testimage.jpg,2222");
        b.add(a);
        File file = new File("/Users/denis/Desktop/Cs320v2/ItemTable.xlsx");

        test.uploadImageWithStartID(readExcelFile.read(file),1);
    }

    @Test
    void addbatch() throws IOException {
        File file = new File("/Users/denis/Desktop/Cs320v2/ItemTable.xlsx");
        test.AddItemBatch(readExcelFile.read(file),1);
    }
}