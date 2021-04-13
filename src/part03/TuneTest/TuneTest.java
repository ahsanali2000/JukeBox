package part03.TuneTest;

import static org.junit.Assert.*;
import org.junit.Test;
import part01.MP3Player;

import part01.Genre;
import part01.Tune;

public class TuneTest {
    @Test
    public void setup() {
        Tune tune = new Tune("Four Seasons - Winter1", "Vivaldi", 5500, Genre.CLASSICAL);
        assertEquals(1,tune.getSongId());
        assertEquals("Four Seasons - Winter1", tune.getTitle());
        assertEquals("Vivaldi", tune.getArtist());
        assertEquals(5500, tune.getDuration());
        assertEquals(Genre.CLASSICAL, tune.getGenre());
        assertEquals(0, tune.getPlayCount());
        assertEquals("1, Four Seasons - Winter1, Vivaldi, 5500, 0, Classical",tune.play());
    }
}
