import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ItemShowTest {
    static ItemShow show;

    public ItemShowTest(){

    }
    @BeforeAll
    public static void setUpClass(){show = new ItemShow();}

    @AfterAll
    public static void tearDownClass(){
        show = null;
    }



    @BeforeEach
    void setUp() {
        show = null;

    }

    @AfterEach
    void tearDown() {
        show = null;
    }



    @Test
    public void doneButtonTest(){
        show = new ItemShow();
        show.DoneButton.doClick();
    }
}