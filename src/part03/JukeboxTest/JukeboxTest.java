package part03.JukeboxTest;

import static org.junit.Assert.*;
import org.junit.Test;
import part01.Genre;
import part02.Jukebox;

import java.io.FileNotFoundException;

public class JukeboxTest {
    @Test
    public void setup() throws FileNotFoundException {

        Jukebox myPlayer = new Jukebox();
        myPlayer.addTune("One1", "U2", 380, Genre.ROCK);
        myPlayer.addTune("One2", "U2", 380, Genre.ROCK);
        myPlayer.setCredits(100);
        myPlayer.setCostPerCredit(1);
        myPlayer.play(1);
        assertEquals(99, myPlayer.getCredits());

        myPlayer.setCredits(0);
        myPlayer.setCostPerCredit(0);
        assertEquals("Playing...\t1\t One1\t U2\t 380\t 2\t Rock and Roll",myPlayer.play(1));

        myPlayer.setCostPerCredit(1);
        assertEquals("Not enough credits to play the tune!",myPlayer.play(1));

        myPlayer.setCredits(10);
        myPlayer.setCostPerCredit(1);

        myPlayer.switchOff();
        myPlayer.switchOn();
        assertEquals(1,myPlayer.getCostPerCredit());
        assertEquals(10,myPlayer.getCredits());
    }
}

