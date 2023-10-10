import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int numDroidsAll = 6;
    private static int numDroids = 10;

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        List<Droid> DroidsAll = new ArrayList<>();
        DroidsFunc.allDroids(DroidsAll);

        Droid[] Droids1 = new Droid[10];
        Droid[] Droids2 = new Droid[10];

        List<Integer> moves = new ArrayList<>();

        while (true) {
            MainFunc.menu(DroidsAll, Droids1, Droids2, moves);
        }
    }

    public static int getNumDroids() {
        return numDroids;
    }

    public static void setNumDroids(int num) {
        numDroids = num;
    }

    public static int getNumDroidsAll() {
        return numDroidsAll;
    }

    public static void setNumDroidsAll(int num) {
        numDroidsAll = num;
    }
}
