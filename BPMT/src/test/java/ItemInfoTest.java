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
public class ItemInfoTest {
    ItemInfo test;
    public ItemInfoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        
    }
    
    @AfterAll
    public static void tearDownClass() {
     
    }
    
    @BeforeEach
    public void setUp() {
        test = new ItemInfo();
    }
    
    @AfterEach
    public void tearDown() {
        test = null;
    }

    @Test
   
    
    public void testproperStock() {
        String test2 = "-10";
        int finall = 10;
        finall = test.properStock(test2);
        assertEquals(10,finall);
    }
    
}
