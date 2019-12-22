import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SendFileTest {
    static SendFile test;


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createSession() {
        test= new SendFile();
        test.createSession("dozpinar","buildpc.software",22,"/Volumes/GoogleDrive/My Drive/NetBeansProjects/TestProject320cs/ssh_key.txt",null);

    }

    @Test
    void copyLocalToRemote() throws IOException, JSchException {
       test = new SendFile();
       Session tmp = SendFile.createSession("dozpinar","buildpc.software",22,"/Volumes/GoogleDrive/My Drive/NetBeansProjects/TestProject320cs/ssh_key.txt",null);
      // test.copyLocalToRemote(tmp,"/Users/denis/Desktop/Cs320v2/testimage.jpg","/var/www/static.buildpc.software/public/","testimage.jpg");
       assertTrue(test.copyLocalToRemote(tmp,"/Users/denis/Desktop/Cs320v2/testimage.jpg","/var/www/static.buildpc.software/public/","testimage.jpg"));
    }


    @Test
    void SRSBPPBPMT0014() throws IOException, JSchException {
        test = new SendFile();
        Session tmp = SendFile.createSession("dozpinar","buildpc.software",22,"/Volumes/GoogleDrive/My Drive/NetBeansProjects/TestProject320cs/ssh_key.txt",null);
        // test.copyLocalToRemote(tmp,"/Users/denis/Desktop/Cs320v2/testimage.jpg","/var/www/static.buildpc.software/public/","testimage.jpg");
        assertFalse(test.copyLocalToRemote(tmp,"/Users/denis/Desktop/Cs320v2/testimage17mb.jpg","/var/www/static.buildpc.software/public/","testimage.jpg"));
    }

    @Test
    void checkAck() {
    }
}