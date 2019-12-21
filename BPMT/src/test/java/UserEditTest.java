import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class UserEditTest {

    static UserEdit test;

    public UserEditTest(){

    }
    @BeforeAll
    public static void setUpClass(){test = new UserEdit();}

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
    public void frameCreationTest1(){
        test = new UserEdit();
        test.closeButton.doClick();
    }




}