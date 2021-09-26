package tubes.algeo.menu;
import tubes.algeo.lib.type.Matriks;
import tubes.algeo.lib.util.terminalColor;

import java.util.Scanner;

public class menuSPL {
    public static Scanner source = new Scanner(System.in);
    public static void menu(){
        menuspl();
    }
    public static void  menuspl() {
        System.out.println(terminalColor.TEXT_BLUE + "\n" +
                "███████╗██████╗ ██╗     \n" +
                "██╔════╝██╔══██╗██║     \n" +
                "███████╗██████╔╝██║     \n" +
                "╚════██║██╔═══╝ ██║     \n" +
                "███████║██║     ███████╗\n" +
                "╚══════╝╚═╝     ╚══════╝\n" +
                "                        \n" + terminalColor.TEXT_RESET);
        System.out.print("Jumlah variabel: ");
        int jumlah_variabel = source.nextInt();
        System.out.println("");
        System.out.print("Jumlah persamaan: ");
        int jumlah_persamaan = source.nextInt();
        System.out.println("");
        Matriks spl = new Matriks(jumlah_persamaan, jumlah_variabel+1);
        for(int i = 0; i < jumlah_persamaan; i++) {
            for (int j = 0; j < jumlah_variabel + 1; j++) {
                if (j < jumlah_variabel) {
                    System.out.print("x" + j + " = ");
                } else {
                    System.out.print("constant = ");
                }
                spl.setElmt(i, j, source.nextInt());
                System.out.print(" ");
            }
            System.out.println("");
        }
        spl.eliminasiGaussJordan();
    }
}
