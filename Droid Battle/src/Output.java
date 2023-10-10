public class Output {
    public static void showTable(Droid[] Droids1, Droid[] Droids2){
        showDroids(Droids1);
        centerLine();
        showDroids(Droids2);
    }

    public static void centerLine(){
        System.out.printf("\n");
        for(int i=0;i<Main.getNumDroids();i++){
            System.out.print("___________");
        }
        for(int i=0;i<Main.getNumDroids()-1;i++){
            System.out.print("___");
        }
        System.out.printf("\n");
    }

    public static void showDroids(Droid[] Droids1){
        String RESET = "\u001B[0m";
        String YELLOW = "\u001B[33m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        for(int i=0;i<Main.getNumDroids();i++){
            System.out.print(" _________ " + "   ");
        }

        System.out.print("\n");

        for(int i=0;i<Main.getNumDroids();i++){
            System.out.print("/         \\" + "   ");
        }

        System.out.print("\n");

        for(int i=0;i<Main.getNumDroids();i++){
            System.out.print("|" + Droids1[i].getName());
            if(Droids1[i].getName().length()>9) {
                System.out.print("       ");
            }
            else{
                for (int j = 0; j < 9 - Droids1[i].getName().length(); j++) {
                    System.out.print(" ");
                }
            }
            System.out.print("|" + "   ");
        }

        System.out.print("\n");

        for(int i=0;i<Main.getNumDroids();i++){
            System.out.print("|_________|" + "   ");
        }

        System.out.print("\n");

        for(int i=0;i<Main.getNumDroids();i++){
            if(Droids1[i].getAbilities().isEmpty()) {
                System.out.print("|         |" + "   ");
            }
            else{
                if ((Droids1[i].getAbilities()).get(0) != null) {
                    System.out.print("|" + GREEN + Droids1[i].getAbilities().get(0) + RESET);
                    for (int j = 0; j < 9 - Droids1[i].getAbilities().get(0).length(); j++) {
                        System.out.print(" ");
                    }
                    System.out.print("|" + "   ");
                }
            }
        }

        System.out.print("\n");

        for(int i=0;i<Main.getNumDroids();i++){
            if(Droids1[i].getAbilities().size() >=2 && (Droids1[i].getAbilities()).get(1) != null) {
                System.out.print("|" + GREEN + Droids1[i].getAbilities().get(1) + RESET);
                for (int j = 0; j < 9 - Droids1[i].getAbilities().get(1).length(); j++) {
                    System.out.print(" ");
                }
                System.out.print("|" + "   ");
            }
            else{
                System.out.print("|         |" + "   ");
            }
        }

        System.out.print("\n");

        for(int i=0;i<Main.getNumDroids();i++){
            System.out.print("|_________|" + "   ");
        }

        System.out.print("\n");

        for(int i=0;i<Main.getNumDroids();i++){
            if(Droids1[i].getDmg()>99){
                System.out.print("|" + YELLOW + Droids1[i].getDmg() + RESET + " | ");
            }
            else if(Droids1[i].getDmg()>9){
                System.out.print("| " + YELLOW + Droids1[i].getDmg() + RESET + " | ");
            }
            else{
                System.out.print("| " + YELLOW + "0" + Droids1[i].getDmg() + RESET + " | ");
            }


            if(Droids1[i].getHp()>99){
                System.out.print(RED + Droids1[i].getHp() + RESET + "|");
            }
            else if(Droids1[i].getHp()>9){
                System.out.print(RED + Droids1[i].getHp() + RESET + " |");
            }
            else{
                System.out.print(RED + "0" + Droids1[i].getHp() + RESET + " |");
            }

            System.out.print("   ");
        }

        System.out.print("\n");

        for(int i=0;i<Main.getNumDroids();i++){
            System.out.print("\\____|____/" + "   ");
        }

    }

    public static void showAttack(Droid DroidAtk, Droid DroidDef){
        String RESET = "\u001B[0m";
        String YELLOW = "\u001B[33m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        for(int i=0;i<2;i++){
            System.out.print(" _________ " + "      ");
        }

        System.out.print("\n");

        for(int i=0;i<2;i++){
            System.out.print("/         \\" + "      ");
        }

        System.out.print("\n");

        System.out.print("|" + DroidAtk.getName());
        for (int j = 0; j < 9 - DroidAtk.getName().length(); j++) {
            System.out.print(" ");
        }
        System.out.print("|" + "      ");

        System.out.print("|" + DroidDef.getName());
        for (int j = 0; j < 9 - DroidDef.getName().length(); j++) {
            System.out.print(" ");
        }
        System.out.print("|" + "      ");

        System.out.print("\n");

        System.out.print("|_________| ---> |_________|");

        System.out.print("\n");

        if(DroidAtk.getAbilities().isEmpty()) {
            System.out.print("|         |" + "      ");
        }
        else{
            if ((DroidAtk.getAbilities()).get(0) != null) {
                System.out.print("|" + GREEN + DroidAtk.getAbilities().get(0) + RESET);
                for (int j = 0; j < 9 - DroidAtk.getAbilities().get(0).length(); j++) {
                    System.out.print(" ");
                }
                System.out.print("|" + "      ");
            }
        }

        if(DroidDef.getAbilities().isEmpty()) {
            System.out.print("|         |" + "      ");
        }
        else{
            if ((DroidDef.getAbilities()).get(0) != null) {
                System.out.print("|" + GREEN + DroidDef.getAbilities().get(0) + RESET);
                for (int j = 0; j < 9 - DroidDef.getAbilities().get(0).length(); j++) {
                    System.out.print(" ");
                }
                System.out.print("|" + "      ");
            }
        }

        System.out.print("\n");

        if(DroidAtk.getAbilities().isEmpty()) {
            System.out.print("|         |" + "      ");
        }
        else{
            if (DroidAtk.getAbilities().size() >=2 && (DroidAtk.getAbilities()).get(1) != null) {
                System.out.print("|" + GREEN + DroidAtk.getAbilities().get(1) + RESET);
                for (int j = 0; j < 9 - DroidAtk.getAbilities().get(1).length(); j++) {
                    System.out.print(" ");
                }
                System.out.print("|" + "      ");
            }
            else{
                System.out.print("|         |" + "      ");
            }
        }

        if(DroidDef.getAbilities().isEmpty()) {
            System.out.print("|         |" + "      ");
        }
        else{
            if (DroidDef.getAbilities().size() >=2 && (DroidDef.getAbilities()).get(1) != null) {
                System.out.print("|" + GREEN + DroidDef.getAbilities().get(1) + RESET);
                for (int j = 0; j < 9 - DroidDef.getAbilities().get(1).length(); j++) {
                    System.out.print(" ");
                }
                System.out.print("|" + "      ");
            }
            else{
                System.out.print("|         |" + "      ");
            }
        }

        System.out.print("\n");

        System.out.print("|_________| ---> |_________|");

        System.out.print("\n");


        if(DroidAtk.getDmg()>99){
            System.out.print("|" + YELLOW + DroidAtk.getDmg() + RESET + " | ");
        }
        else if(DroidAtk.getDmg()>9){
            System.out.print("| " + YELLOW + DroidAtk.getDmg() + RESET + " | ");
        }
        else{
            System.out.print("| " + YELLOW + "0" + DroidAtk.getDmg() + RESET + " | ");
        }

        if(DroidAtk.getHp()>99){
            System.out.print(RED + DroidAtk.getHp() + RESET + "| ");
        }
        else if(DroidAtk.getHp()>9){
            System.out.print(RED + DroidAtk.getHp() + RESET + " | ");
        }
        else{
            System.out.print(RED + "0" + DroidAtk.getHp() + RESET + " | ");
        }

        System.out.print("     ");

        if(DroidDef.getDmg()>99){
            System.out.print("|" + YELLOW + DroidDef.getDmg() + RESET + " | ");
        }
        else if(DroidDef.getDmg()>9){
            System.out.print("| " + YELLOW + DroidDef.getDmg() + RESET + " | ");
        }
        else{
            System.out.print("| " + YELLOW + "0" + DroidDef.getDmg() + RESET + " | ");
        }

        if(DroidDef.getHp()>99){
            System.out.print(RED + DroidDef.getHp() + RESET + "| ");
        }
        else if(DroidDef.getHp()>9){
            System.out.print(RED + DroidDef.getHp() + RESET + " | ");
        }
        else{
            System.out.print(RED + "0" + DroidDef.getHp() + RESET + " | ");
        }

        System.out.print("\n");

        for(int i=0;i<2;i++){
            System.out.print("\\____|____/" + "      ");
        }
    }
}
