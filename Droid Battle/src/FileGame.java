import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FileGame {
    public static void startFileGame(Droid[] Droids1, Droid[] Droids2, Scanner scanner, List<Integer> moves) throws InterruptedException {
        Output.showTable(Droids1, Droids2);
        MainFunc.pressToStart();
        int numAtk1 = Main.getNumDroids() - 1;
        int numAtk2 = Main.getNumDroids() - 1;
        int count = 0;

        while (checkFunc.checkAlive(Droids1, Droids2)) {
            Thread.sleep(4000);
            numAtk1 = MainFunc.nextAttack(numAtk1, Droids1);
            System.out.println("\nPlayer 1 attacking:");
            count += attackFile(numAtk1, moves.get(count), Droids1, Droids2, moves, count);
            Output.showTable(Droids1, Droids2);
            if (!checkFunc.checkAlive(Droids1, Droids2)) {
                break;
            }
            Thread.sleep(4000);
            numAtk2 = MainFunc.nextAttack(numAtk2, Droids2);
            System.out.println("\nPlayer 2 attacking:");
            count += attackFile(numAtk2, moves.get(count), Droids2, Droids1, moves, count);
            Output.showTable(Droids1, Droids2);
            if (!checkFunc.checkAlive(Droids1, Droids2)) {
                break;
            }
        }

        checkFunc.checkWinner(Droids1, Droids2);
    }

    public static int attackFile(int numAtk, int numDef, Droid[] Droids1, Droid[] Droids2, List<Integer> moves, int count) {
        Random random = new Random();
        if (checkFunc.checkCanAttack(numAtk, numDef, Droids1, Droids2)) {
            Output.showAttack(Droids1[numAtk], Droids2[numDef]);
            System.out.println("\n" + (numAtk + 1) + " Attacked " + (numDef + 1));
            MainFunc.attacking(numAtk, numDef, Droids1, Droids2);
        } else {
            attackFile(numAtk, random.nextInt(Main.getNumDroids()), Droids1, Droids2, moves, count);

        }
        if (Droids1[numAtk].checkWind()) {
            Droids1[numAtk].deleteAbility("Wind");
            if (checkFunc.checkAlive(Droids1, Droids2)) {
                attackFile(numAtk, moves.get(count+1), Droids1, Droids2, moves, count);
                return 2;
            }
        }
        return 1;
    }

    public static void playBattleFile(Droid[] Droids1, Droid[] Droids2, List<Integer> moves) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        try {
            FileInputStream fileInputStream = new FileInputStream("numDroids.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Main.setNumDroids((int) objectInputStream.readObject());
            objectInputStream.close();
            fileInputStream.close();

            fileInputStream = new FileInputStream("droids1.ser");
            objectInputStream = new ObjectInputStream(fileInputStream);
            Droids1 = (Droid[]) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            DroidsFunc.repairTeam(Droids1);

            fileInputStream = new FileInputStream("droids2.ser");
            objectInputStream = new ObjectInputStream(fileInputStream);
            Droids2 = (Droid[]) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            DroidsFunc.repairTeam(Droids2);

            fileInputStream = new FileInputStream("moves.ser");
            objectInputStream = new ObjectInputStream(fileInputStream);
            moves = (List<Integer>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        startFileGame(Droids1, Droids2, scanner, moves);
    }

    public static void recordBattleFile(Droid[] Droids1, Droid[] Droids2, List<Integer> moves) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("numDroids.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(Main.getNumDroids());
            objectOutputStream.close();
            fileOutputStream.close();

            fileOutputStream = new FileOutputStream("droids1.ser");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(Droids1);
            objectOutputStream.close();
            fileOutputStream.close();

            fileOutputStream = new FileOutputStream("droids2.ser");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(Droids2);
            objectOutputStream.close();
            fileOutputStream.close();

            fileOutputStream = new FileOutputStream("moves.ser");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(moves);
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
