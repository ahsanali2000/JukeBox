package part03.MP3PlayerTest;
import static org.junit.Assert.*;
import org.junit.Test;
import part01.Genre;
import part01.MP3Player;

public class addTuneTest {
    @Test
    public void setup(){

        MP3Player myPlayer = new MP3Player();

        boolean added = myPlayer.addTune("One1", "U2", 380, Genre.ROCK);
        assertNotNull(added);

        added = myPlayer.addTune("One1", "U2", 380, Genre.ROCK);
        assertEquals(false, added);


    }
}

