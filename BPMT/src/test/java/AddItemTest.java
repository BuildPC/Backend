/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Denizcan
 */
public class AddItemTest {
    AddItem test;
    public AddItemTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        test =null;
    }
    
    @AfterEach
    public void tearDown() {
        test = null;
    }

    /**
     * Test of convertFileContentToBlob method, of class AddItem.
     */
   

    /**
  
     */
    @Test
    public void testCategorizer() {
        String input = "MotherBoard";
        int tmp = 0;
        tmp = test.categorizer(input);
        assertEquals(0,tmp);
    }
    
    @Test
    public void testCategorizer2() {
        String input = "RAM";
        int tmp = 0;
        tmp = test.categorizer(input);
        assertEquals(4,tmp);
    }
    @Test
    public void testCategorizer3() {
        String input = "alaska";
        int tmp = 0;
        tmp = test.categorizer(input);
        assertEquals(-1,tmp);
    }
    @Test
    public void testCategorizer4() {
        String input = "CPU";
        int tmp = 0;
        tmp = test.categorizer(input);
        assertEquals(1,tmp);
    }

    @Test
    public void testCategorizer5() {
        String input = "GPU";
        int tmp = 0;
        tmp = test.categorizer(input);
        assertEquals(2,tmp);
    }
    @Test
    public void testCategorizer6() {
        String input = "SSD";
        int tmp = 0;
        tmp = test.categorizer(input);
        assertEquals(3,tmp);
    }

    @Test
    public void testCategorizer7() {
        String input = "PSY";
        int tmp = 0;
        tmp = test.categorizer(input);
        assertEquals(5,tmp);
    }

    @Test
    public void testCategorizer8() {
        String input = "Mouse";
        int tmp = 0;
        tmp = test.categorizer(input);
        assertEquals(6,tmp);
    }

    @Test
    public void testCategorizer9() {
        String input = "Keyboard";
        int tmp = 0;
        tmp = test.categorizer(input);
        assertEquals(7,tmp);
    }

    @Test
    public void testCategorizer10() {
        String input = "Case";
        int tmp = 0;
        tmp = test.categorizer(input);
        assertEquals(8,tmp);
    }



    @Test
    public void additemuploadButtonTest(){
        test = new AddItem();
        test.uploadButton.doClick();
    }


    @Test
    public void addItemAddBJButton1(){
        test = new AddItem();
        test.jButton1.doClick();
    }










  //  @Test
//    public void testuploadphoto() throws UnsupportedEncodingException {
//        String path= "/Users/denis/Desktop/Cs320v2/2/COOLER MASTER MASTERBOX MB501L.jpg";
//        File file = new File(URLDecoder.decode(path, "UTF-8"));
//        String tmp ="";
//        tmp =  test.uploadImage(file);
//        int id = SQLUtilities.currenid(Frame.conn)+1;
//
//        assertEquals(""+id+"jpg",tmp);
//    }

    /**
     
     */
    @Test
    public void testProperfloat() {
        String test2 = "-10";
        double finall = 10;
        finall = test.properfloat(test2);
        assertEquals(10,finall);
    }
    
     @Test
    public void testProperfloat1() {
        String test1 = "4,51";
        double finall = 0.0f;
        finall = test.properfloat(test1);
        assertEquals(4.51,finall);
    }
     @Test
    public void testProperfloat2() {
        String test1 = "2.747,04";
        double finall = 0.0f;
        finall = test.properfloat(test1);
        assertEquals(2747.04,finall);
    }
     @Test
    public void testProperfloat3() {
        String test1 = "-2.747,04";
        double finall = 0.0f;
        finall = test.properfloat(test1);
        assertEquals(2747.04,finall);
    }
    
}
