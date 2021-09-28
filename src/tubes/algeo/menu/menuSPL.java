package tubes.algeo.menu;
import tubes.algeo.lib.SPL;
import tubes.algeo.lib.type.Matriks;
import tubes.algeo.lib.type.SPLResult;
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

        Matriks augmented = menuInput.getMatriks("Sistem Persamaan Linear",
                "Masukkan matriks augmented yang diinginkan");

        try {
            int algorithm = menuInput.getMethod("Sistem Persamaan Linear");
            SPLResult result;

            switch (algorithm){
                case menuInput.METHOD_ELIMINASI_GAUSS:
                    result = SPL.gaussElimination(augmented);
                    break;
                case menuInput.METHOD_ELIMINASI_GAUSS_JORDAN:
                    result = SPL.gaussJordanElimination(augmented);
                    break;
                case menuInput.METHOD_INVERSE:
                    result = SPL.matriksInverseMethod(augmented);
                    break;
                case menuInput.METHOD_CRAMER:
                    result = SPL.cramer(augmented);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + algorithm);
            }

            menuOutput.showSPLDefinitonResult(result);
        }catch (Exception e){
            System.out.println(terminalColor.TEXT_RED +"Oopss..");
            System.out.println("Terjadi Eksepsi saat melakukan pembacaan data. \n" + terminalColor.TEXT_RESET);
            System.out.println("Detail Kesalahan: ");
            System.out.println(e.getMessage());

            System.out.print("\n**** Silahkan tekan enter untuk melanjutkan program ****");
            try{
                System.in.read();
            }catch(Exception ignored){
            }
        }
    }
}
