public class checkFunc {
    public static boolean checkAlive(Droid[] Droids1, Droid[] Droids2) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < Main.getNumDroids(); i++) {
            if (Droids1[i].getHp() != 0) {
                count1++;
            }

            if (Droids2[i].getHp() != 0) {
                count2++;
            }
        }

        if (count2 == 0 || count1 == 0) {
            return false;
        }
        return true;
    }

    public static void checkWinner(Droid[] Droids1, Droid[] Droids2) {
        for (int i = 0; i < Main.getNumDroids(); i++) {
            if (Droids1[i].getHp() != 0) {
                System.out.println("\n\u001B[32mBot win\u001B[0m\n");
                return;
            }
        }
        for (int i = 0; i < Main.getNumDroids(); i++) {
            if (Droids2[i].getHp() != 0) {
                System.out.println("\n\u001B[32mPlayer win\u001B[0m\n");
                return;
            }
        }
        System.out.println("\n\u001B[32mDraw\u001B[0m\n");
    }

    public static boolean checkCanAttack(int numAtk, int numDef, Droid[] Droids1, Droid[] Droids2) {
        if (Droids2[numDef].getHp() == 0) {
            return false;
        }
        if (Droids1[numAtk].checkRat()) {
            return true;
        }
        if (Droids2[numDef].checkTaunt()) {
            return true;
        } else {
            for (int i = 0; i < Main.getNumDroids(); i++) {
                if (i != numDef) {
                    if (Droids2[i].checkTaunt()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
