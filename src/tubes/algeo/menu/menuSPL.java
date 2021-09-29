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

        Matriks augmented = menuInput.getMatriks(terminalColor.TEXT_GREEN+"Sistem Persamaan Linear"+terminalColor.TEXT_RESET,
                "Masukkan matriks augmented yang diinginkan");

        try {
            int algorithm = menuInput.getMethod(terminalColor.TEXT_CYAN+"Sistem Persamaan Linear"+terminalColor.TEXT_RESET);
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
                    throw new IllegalStateException(terminalColor.TEXT_RED+"Unexpected value: " + algorithm+terminalColor.TEXT_RESET);
            }

            menuOutput.showSPLDefinitonResult(result);
        }catch (Exception e){
            System.out.println(terminalColor.TEXT_RED +"Oopss.."+terminalColor.TEXT_RESET);
            System.out.println("Terjadi Eksepsi saat melakukan pembacaan data. \n" + terminalColor.TEXT_RESET);
            System.out.println(terminalColor.TEXT_BLUE+"Detail Kesalahan: "+terminalColor.TEXT_RESET);
            System.out.println(e.getMessage());


            System.out.print(terminalColor.TEXT_CYAN+"\n**** Silahkan tekan enter untuk melanjutkan program ****"+terminalColor.TEXT_RESET);
            try{
                System.in.read();
            }catch(Exception ignored){
            }
        }
    }
}
