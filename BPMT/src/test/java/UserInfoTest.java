import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class UserInfoTest {
    static UserInfo test;

    public UserInfoTest(){

    }
    @BeforeAll
    public static void setUpClass(){test = new UserInfo();}

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









}