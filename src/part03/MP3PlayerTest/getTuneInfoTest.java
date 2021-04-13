package part03.MP3PlayerTest;
import static org.junit.Assert.*;
import org.junit.Test;
import part01.Genre;
import part01.MP3Player;

public class getTuneInfoTest {
    @Test
    public void setup(){

        MP3Player myPlayer = new MP3Player();

        String[] allTunes = myPlayer.getTuneInfo();
        assertNull(allTunes);

        myPlayer.addTune("One1", "U2", 380, Genre.ROCK);
        myPlayer.addTune("Four Seasons - Winter1", "Vivaldi", 5500, Genre.CLASSICAL);

        allTunes = myPlayer.getTuneInfo();
        assertNotNull(allTunes);
        String[] expectedList = {"2, Four Seasons - Winter1, Vivaldi, 5500, 0, Classical", "1, One1, U2, 380, 0, Rock and Roll"};
        assertEquals(allTunes,expectedList);

    }
}
