import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
public class DroidsFunc {
    public static void createArrray(Droid[] Droids2, List<Droid> DroidsAll, Scanner scanner) {
        MainFunc.showAllDroids(DroidsAll);
        System.out.println("Choose " + Main.getNumDroids() + " Droids(Enter sequence number):");
        for (int i = 0; i < Main.getNumDroids(); i++) {
            while (true) {
                int num = scanner.nextInt();
                if (num >= 1 && num <= Main.getNumDroidsAll()) {
                    Droids2[i] = createCopy(DroidsAll.get(num - 1));
                    break;
                } else {
                    System.out.println("Enter again");
                }
            }
        }
    }

    public static void createRandomArrray(Droid[] Droids1, List<Droid> DroidsAll) {
        Random random = new Random();
        int rNum;
        for (int i = 0; i < Main.getNumDroids(); i++) {
            rNum = random.nextInt(Main.getNumDroidsAll());
            Droids1[i] = createCopy(DroidsAll.get(rNum));
        }
    }

    public static void allDroids(List<Droid> DroidsAll) {
        for (int i = 0; i < Main.getNumDroidsAll(); i++) {
            DroidsAll.add(createStartDroids(i + 1));
        }
    }

    public static void deleteDrone(int num, Droid[] Droids) {
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        if (Droids[num].getHp() == 0) {
            Droids[num].setName(RED + "GG" + RESET);
            Droids[num].setDmg(0);
            Droids[num].setAbilities(new ArrayList<>(List.of("")));
        }
    }

    public static void createDroid(List<Droid> DroidsAll) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter attack (0-99):");
        int atk = scanner.nextInt();
        while (atk < 0 || atk > 99) {
            System.out.println("Enter attack (0-99):");
            atk = scanner.nextInt();

            if (atk < 0 || atk > 99) {
                System.out.println("Error");
            }
        }
        System.out.println("Enter health (0-99):");
        int hp = scanner.nextInt();
        while (hp < 0 || hp > 99) {
            System.out.println("Enter health (0-99):");
            hp = scanner.nextInt();

            if (hp < 0 || hp > 99) {
                System.out.println("Error");
            }
        }

        System.out.println("Add abilities:");
        System.out.println("1. Rat;");
        System.out.println("2. Shield;");
        System.out.println("3. Wind;");
        System.out.println("4. Taunt;");
        System.out.println("5. Doubler;");
        System.out.println("6. None;");

        switch (scanner.nextInt()) {
            case 1:
                DroidsAll.add(Main.getNumDroidsAll(), new Sniper1("ВВ-8", atk, hp));
                Main.setNumDroidsAll(Main.getNumDroidsAll()+1);
                break;
            case 2:
                DroidsAll.add(Main.getNumDroidsAll(), new Undead1("K-2SO", atk, hp));
                Main.setNumDroidsAll(Main.getNumDroidsAll()+1);
                break;
            case 3:
                DroidsAll.add(Main.getNumDroidsAll(), new Pusher1("HK-47", atk, hp));
                Main.setNumDroidsAll(Main.getNumDroidsAll()+1);
                break;
            case 4:
                DroidsAll.add(Main.getNumDroidsAll(), new Tank1("R2-D2", atk, hp));
                Main.setNumDroidsAll(Main.getNumDroidsAll()+1);
                break;
            case 5:
                DroidsAll.add(Main.getNumDroidsAll(), new Killer1("IG-88", atk, hp));
                Main.setNumDroidsAll(Main.getNumDroidsAll()+1);
                break;
            case 6:
                DroidsAll.add(Main.getNumDroidsAll(), new Normal1("C1-10P", atk, hp));
                Main.setNumDroidsAll(Main.getNumDroidsAll()+1);
                break;
            default:
                System.out.println("Error entry");
        }

        System.out.println("\n\u001B[32mDroid created\u001B[0m\n");
    }

    public static void repairTeam(Droid[] Droids) {
        for (int i = 0; i < Main.getNumDroids(); i++) {
            Droids[i].repair();
        }
    }

    public static Droid createCopy(Droid droid) {
        switch (droid.getAbilities().get(0)) {
            case "Taunt":
                return new Tank1("R2-D2", droid.getDmg(), droid.getHp());
            case "Rat":
                return new Sniper1("BB-8", droid.getDmg(), droid.getHp());
            case "Doubler":
                return new Killer1("IG-88", droid.getDmg(), droid.getHp());
            case "Shield":
                return new Undead1("K-2SO", droid.getDmg(), droid.getHp());
            case "Wind":
                return new Pusher1("HK-47", droid.getDmg(), droid.getHp());
        }
        return new Normal1("C1-10P", droid.getDmg(), droid.getHp());
    }

    public static Droid createStartDroids(int num) {
        switch (num) {
            case 1:
                return new Tank1("R2-D2", 4, 17);
            case 2:
                return new Sniper1("BB-8", 10, 6);
            case 3:
                return new Killer1("IG-88", 14, 7);
            case 4:
                return new Undead1("K-2SO", 14, 8);
            case 5:
                return new Pusher1("HK-47", 2, 10);
            case 6:
                return new Normal1("C1-10P", 15, 16);
        }
        return new Tank1("Error-No", 15, 15);
    }
}

