package part03.MP3PlayerTest;
import static org.junit.Assert.*;
import org.junit.Test;
import part01.Genre;
import part01.MP3Player;

import java.io.FileNotFoundException;

public class switchTest {
    @Test
    public void setup() throws FileNotFoundException {

        MP3Player myPlayer = new MP3Player();

        boolean status = myPlayer.switchOn();
        assertEquals(false,status);


        status = myPlayer.switchOff();
        assertEquals(true,status);

        status = myPlayer.switchOff();
        assertEquals(false,status);

        status = myPlayer.switchOn();
        assertEquals(true,status);

    }
}

