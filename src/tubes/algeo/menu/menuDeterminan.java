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

        Matriks input = menuInput.getMatriks("Determinan", "Masukan matriks yang ingin dihitung determinannya");
        if (input.isSquare()) {
            String[] metode = {"Metode Reduksi Baris", "Metode Kofaktor"};
            double determinan;

            int pilihan = menuInput.pilihanOpsi(metode, "Pilih metode perhitungan yang diinginkan");
            switch (pilihan){
                case 1:
                    determinan = input.determinanByReduksi();
                    break;
                case 2:
                    determinan = input.determinanByKofaktor();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + pilihan);
            }

            menuOutput.showResult((new Double(determinan)).toString());
        } else {
            System.out.println("Matriks haruslah berupa matriks persegi.");
        }
    }
}
