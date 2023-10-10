import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MainFunc {
    public static void menu(List<Droid> DroidsAll, Droid[] Droids1, Droid[] Droids2, List<Integer> moves) throws InterruptedException, FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Create droid;");
        System.out.println("2. Show all droids;");
        System.out.println("3. 1 vs 1 battle;");
        System.out.println("4. Team vs team;");
        System.out.println("5. Write to a file;");
        System.out.println("6. Play a battle from a file;");
        System.out.println("7. Exit;");
        switch (scanner.nextInt()) {
            case 1:
                DroidsFunc.createDroid(DroidsAll);
                break;
            case 2:
                showAllDroids(DroidsAll);
                break;
            case 3:
                moves.clear();
                soloBattle(DroidsAll, Droids1, Droids2, moves);
                break;
            case 4:
                moves.clear();
                teamBattle(DroidsAll, Droids1, Droids2, moves);
                break;
            case 5:
                FileGame.recordBattleFile(Droids1, Droids2, moves);
                break;
            case 6:
                FileGame.playBattleFile(Droids1, Droids2, moves);
                break;
            case 7:
                System.exit(0);
        }
    }

    public static void teamBattle(List<Droid> DroidsAll, Droid[] Droids1, Droid[] Droids2, List<Integer> moves) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Number of robots (less than 10):");
            Main.setNumDroids(scanner.nextInt());
            if (Main.getNumDroids() > 10 || Main.getNumDroids() < 1) {
                System.out.println("Error");
            }
        } while (Main.getNumDroids() > 10 || Main.getNumDroids() < 1);

        DroidsFunc.createArrray(Droids2, DroidsAll, scanner);

        DroidsFunc.createRandomArrray(Droids1, DroidsAll);
        startGame(DroidsAll, Droids1, Droids2, scanner, moves);
    }

    public static void soloBattle(List<Droid> DroidsAll, Droid[] Droids1, Droid[] Droids2, List<Integer> moves) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        int temp;
        Main.setNumDroids(1);

        for (int i = 0; i < 10; i++) {
            Droids2[i] = null;
        }
        System.out.println("\nChoose your robot:");
        do {
            showAllDroids(DroidsAll);
            temp = scanner.nextInt() - 1;
            if (temp >= Main.getNumDroidsAll()) {
                System.out.println("Error");
            }
        } while (temp >= Main.getNumDroidsAll());
        Droids2[0] = DroidsFunc.createCopy(DroidsAll.get(temp));

        for (int i = 0; i < 10; i++) {
            Droids1[i] = null;
        }
        System.out.println("Choose opponent robot:");
        do {
            showAllDroids(DroidsAll);
            temp = scanner.nextInt() - 1;
            if (temp >= Main.getNumDroidsAll()) {
                System.out.println("Error");
            }
        } while (temp >= Main.getNumDroidsAll());
        Droids1[0] = DroidsFunc.createCopy(DroidsAll.get(temp));


        startGame(DroidsAll, Droids1, Droids2, scanner, moves);
    }

    public static int nextAttack(int num, Droid[] DroidsOp) {
        num++;
        if (num == Main.getNumDroids()) {
            num = 0;
        }
        while (DroidsOp[num].getHp() == 0) {
            num++;
            if (num == Main.getNumDroids()) {
                num = 0;
            }
        }
        return num;
    }


    public static void startGame(List<Droid> DroidsAll, Droid[] Droids1, Droid[] Droids2, Scanner scanner, List<Integer> moves) throws InterruptedException {
        Random random = new Random();
        Output.showTable(Droids1, Droids2);
        pressToStart();

        int numAtk1 = Main.getNumDroids() - 1;
        int numAtk2 = Main.getNumDroids() - 1;
        int rand;

        while (checkFunc.checkAlive(Droids1, Droids2)) {
            Thread.sleep(4000);
            numAtk1 = nextAttack(numAtk1, Droids1);
            System.out.println("\nPlayer 1 attacking:");
            rand = random.nextInt(Main.getNumDroids());
            attack(numAtk1, rand, Droids1, Droids2, moves);
            Output.showTable(Droids1, Droids2);
            if (!checkFunc.checkAlive(Droids1, Droids2)) {
                break;
            }
            Thread.sleep(4000);
            numAtk2 = nextAttack(numAtk2, Droids2);
            System.out.println("\nPlayer 2 attacking:");
            rand = random.nextInt(Main.getNumDroids());
            attack(numAtk2, rand, Droids2, Droids1, moves);
            Output.showTable(Droids1, Droids2);
            if (!checkFunc.checkAlive(Droids1, Droids2)) {
                break;
            }
        }

        checkFunc.checkWinner(Droids1, Droids2);
    }

    public static void attack(int numAtk, int numDef, Droid[] Droids1, Droid[] Droids2, List<Integer> moves) {
        Random random = new Random();
        if (checkFunc.checkCanAttack(numAtk, numDef, Droids1, Droids2)) {
            moves.add(numDef);
            Output.showAttack(Droids1[numAtk], Droids2[numDef]);
            System.out.println("\n" + (numAtk + 1) + " Attacked " + (numDef + 1));
            attacking(numAtk, numDef, Droids1, Droids2);
        } else {
            attack(numAtk, random.nextInt(Main.getNumDroids()), Droids1, Droids2, moves);

        }
        if (Droids1[numAtk].checkWind()) {
            Droids1[numAtk].deleteAbility("Wind");
            if (checkFunc.checkAlive(Droids1, Droids2)) {
                attack(numAtk, random.nextInt(Main.getNumDroids()), Droids1, Droids2, moves);
            }
        }
    }

    public static void attacking(int numAtk, int numDef, Droid[] Droids1, Droid[] Droids2) {
        if (Droids1[numAtk].checkDoubler()) {
            Droids1[numAtk].setDmg(Droids1[numAtk].getDmg() * 2);
        }
        int atk1 = Droids1[numAtk].getDmg();
        int atk2 = Droids2[numDef].getDmg();

        if (Droids1[numAtk].checkShield()) {
            Droids1[numAtk].deleteAbility("Shield");
        } else {
            dealDmg(atk2, numAtk, Droids2, Droids1);
        }
        if (Droids2[numDef].checkShield()) {
            Droids2[numDef].deleteAbility("Shield");
        } else {
            dealDmg(atk1, numDef, Droids1, Droids2);
        }
        DroidsFunc.deleteDrone(numAtk, Droids1);
        DroidsFunc.deleteDrone(numDef, Droids2);
    }

    public static void dealDmg(int atk, int numDef, Droid[] Droids1, Droid[] Droids2) {
        if (atk > Droids2[numDef].getHp()) {
            Droids2[numDef].setHp(0);
        } else {
            Droids2[numDef].setHp(Droids2[numDef].getHp() - atk);
        }
    }

    public static void showAllDroids(List<Droid> DroidsAll) {
        System.out.println("List of all Droids:");
        for (int i = 0; i < Main.getNumDroidsAll(); i++) {
            System.out.printf(i + 1 + ". " + DroidsAll.get(i).toString());
        }
        System.out.println();
    }

    public static void pressToStart() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nPress 1 to start:");
            if (scanner.nextInt() == 1) {
                return;
            }
        }
    }
}
