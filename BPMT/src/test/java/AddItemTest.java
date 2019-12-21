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
