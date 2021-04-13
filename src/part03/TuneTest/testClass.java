package part03.TuneTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class testClass {
    public static void main(String[] args) {
        Result res = JUnitCore.runClasses(TuneTest.class);
        for (Failure failure : res.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("Tune Tests result: " + res.wasSuccessful());
    }
}
