package part03.MP3PlayerTest;
import static org.junit.Assert.*;
import org.junit.Test;
import part01.Genre;
import part01.MP3Player;

public class playTest{
    @Test
    public void setup(){

        MP3Player myPlayer = new MP3Player();

        String Tunes = myPlayer.play(1);
        assertNull(Tunes);

        myPlayer.addTune("One1", "U2", 380, Genre.ROCK);
        myPlayer.addTune("Four Seasons - Winter1", "Vivaldi", 5500, Genre.CLASSICAL);

        Tunes = myPlayer.play(7);
        assertNotNull(Tunes);
        String expected = "7, One1, U2, 380, 1, Rock and Roll";
        assertEquals(Tunes,expected);

    }
}

