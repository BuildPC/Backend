import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;


public class FrameTest {
    static Frame frame;
    public FrameTest(){

    }

    @BeforeAll
    public static void setUpClass() {
        frame = new Frame();
    }

    @AfterAll
    public static void tearDownClass() {
        frame = null;
    }

    @BeforeEach
    public void setUp() {
        frame =null;
    }

    @AfterEach
    public void tearDown() {
        frame = null;
    }

    @Test
    public void frameCreationTest(){
        frame = new Frame();
        frame.UserButton.doClick();
    }

    @Test
    public void frameCreationTest1(){
        frame = new Frame();
        frame.MainMenuButton.doClick();
    }

    @Test
    public void frameCreationTest2(){
        frame = new Frame();
        frame.ItemButton.doClick();
    }


}
