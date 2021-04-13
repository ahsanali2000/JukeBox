package part03.MP3PlayerTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class testClass {
    public static void main(String[] args) {
        Result res = JUnitCore.runClasses(getTuneInfoTest.class);
        for(Failure failure: res.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("All tunes result: "+res.wasSuccessful());


        res = JUnitCore.runClasses(getArtistTunesTest.class);
        for(Failure failure: res.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("Artist Tunes result: "+res.wasSuccessful());



        res = JUnitCore.runClasses(getGenreTunesTest.class);
        for(Failure failure: res.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("Genre tunes result: "+res.wasSuccessful());

        res = JUnitCore.runClasses(playTest.class);
        for(Failure failure: res.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("Play tune result: "+res.wasSuccessful());

        res = JUnitCore.runClasses(addTuneTest.class);
        for(Failure failure: res.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("Add tune result: "+res.wasSuccessful());

        res = JUnitCore.runClasses(switchTest.class);
        for(Failure failure: res.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("Switch result: "+res.wasSuccessful());
    }
}
