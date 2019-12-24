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
    void SRSBPPBPMT001() throws SQLException {
        int tmp = SQLUtilities.currenid(frame.conn);
        test.AddItem("test2","testvalue",1,2.3f,1,frame.conn,"blob");
        int tmp2 = SQLUtilities.currenid(frame.conn);
        assertEquals(tmp+1,tmp2);
    }

    @Test
    void SRSBPPBPMT001dot3() throws SQLException {
        int tmp = SQLUtilities.currenid(frame.conn);
        test.AddItem("","",1,2.3f,1,frame.conn,"blob");
        int tmp2 = SQLUtilities.currenid(frame.conn);
        assertEquals(tmp+1,tmp2);
    }

    @Test
    void SRSBPPBPMT001dot2() throws SQLException {
        int tmp = SQLUtilities.currenid(frame.conn);
        test.AddItem("test","testvalue",1,2.3f,1,frame.conn,"blob");
        int tmp2 = SQLUtilities.currenid(frame.conn);
        assertEquals(tmp+1,tmp2);
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
        File file = new File("/Users/denis/Desktop/Cs320v2/test1.xlsx");

        test.uploadImageWithStartID(readExcelFile.read(file),1);
    }

    @Test
    void addbatch() throws IOException {
        File file = new File("/Users/denis/Desktop/Cs320v2/test1.xlsx");
        test.AddItemBatch(readExcelFile.read(file),1);
    }

    @Test
    void update_table(){
        frame.UserButton.doClick();
        test.Update_table(UserInfo.UserTable);
    }

    @Test
    void update_tableItem(){
        frame.ItemButton.doClick();
        test.Update_table(ItemInfo.ItemTable);
    }

    @AfterAll
    void cancelall() throws SQLException {
        frame.conn.rollback();
    }
}