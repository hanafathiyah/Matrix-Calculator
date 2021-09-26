package tubes.algeo.menu;
import tubes.algeo.lib.IO;
import tubes.algeo.lib.type.Matriks;
import tubes.algeo.lib.util.terminalColor;
import java.util.Scanner;
public class menuDeterminan {
    public static void menu(){
        menudeterminan();
    }
    public static void  menudeterminan() {
        System.out.println(terminalColor.TEXT_PURPLE + "\n" +
                "██████  ███████ ████████ ███████ ██████  ███    ███ ██ ███    ██  █████  ███    ██ \n" +
                "██   ██ ██         ██    ██      ██   ██ ████  ████ ██ ████   ██ ██   ██ ████   ██ \n" +
                "██   ██ █████      ██    █████   ██████  ██ ████ ██ ██ ██ ██  ██ ███████ ██ ██  ██ \n" +
                "██   ██ ██         ██    ██      ██   ██ ██  ██  ██ ██ ██  ██ ██ ██   ██ ██  ██ ██ \n" +
                "██████  ███████    ██    ███████ ██   ██ ██      ██ ██ ██   ████ ██   ██ ██   ████ \n" +
                "                                                                                   \n" + terminalColor.TEXT_RESET);
        Matriks input = IO.readMatrix();
        if (input.isSquare()) {
            double determinan = input.determinanByKofaktor();
            System.out.println("Determinan matriks tersebut adalah " + determinan+".");
        } else {
            System.out.println("Matriks harus persegi.");
        }
    }
}
