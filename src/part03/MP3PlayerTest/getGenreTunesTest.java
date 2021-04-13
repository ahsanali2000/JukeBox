package part03.MP3PlayerTest;
import static org.junit.Assert.*;
import org.junit.Test;
import part01.Genre;
import part01.MP3Player;

public class getGenreTunesTest {
    @Test
    public void setup(){

        MP3Player myPlayer = new MP3Player();

        String[] allTunes = myPlayer.getTuneInfo(Genre.values()[1]);
        assertNull(allTunes);

        myPlayer.addTune("One1", "U2", 380, Genre.ROCK);
        myPlayer.addTune("Four Seasons - Winter1", "Vivaldi", 5500, Genre.CLASSICAL);

        allTunes = myPlayer.getTuneInfo(Genre.CLASSICAL);
        assertNotNull(allTunes);
        String[] expectedList = {"6, Four Seasons - Winter1, Vivaldi, 5500, 0, Classical"};
        assertEquals(allTunes,expectedList);

    }
}

