/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Denizcan
 */
public class SomeStuffTest {
    AddItem stuff;
    public SomeStuffTest() {
    }
    
    @BeforeEach
    public void setUp() {
        stuff = new AddItem();
    }
    
    @AfterEach
    public void tearDown() {
        stuff = null;
    }

    @Test
    public void testSwitchPanels() {
    }

    @Test
    public void testCategorizer() {
    }

    @Test
    public void testProperfloat() {
        String test = "4,51";
        double finall = 0.0f;
        finall = stuff.properfloat(test);
        assertEquals(4.51,finall);
    }
    
    public void testProperfloat2() {
        String test = "2.747,04";
        double finall = 0.0f;
        finall = stuff.properfloat(test);
        assertEquals(2747.04,finall);
    }
    
    public void testProperfloat3() {
        String test = "-2.747,04";
        double finall = 0.0f;
        finall = stuff.properfloat(test);
        assertEquals(2747.04,finall);
    }
}
