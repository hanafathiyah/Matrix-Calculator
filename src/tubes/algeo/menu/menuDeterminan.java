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

        Matriks input = menuInput.getMatriks(terminalColor.TEXT_GREEN+ "Determinan", "Masukan matriks yang ingin dihitung determinannya"+terminalColor.TEXT_RESET);
        if (input.isSquare()) {
            String[] metode = {terminalColor.TEXT_BLUE+"Metode Reduksi Baris", "Metode Kofaktor"+terminalColor.TEXT_RESET};
            double determinan;

            int pilihan = menuInput.pilihanOpsi(metode, terminalColor.TEXT_RED+ "Pilih metode perhitungan yang diinginkan" + terminalColor.TEXT_RESET);
            switch (pilihan){
                case 1:
                    determinan = input.determinanByReduksi();
                    break;
                case 2:
                    determinan = input.determinanByKofaktor();
                    break;
                default:
                    throw new IllegalStateException(terminalColor.TEXT_RESET+"Unexpected value: " + pilihan + terminalColor.TEXT_RESET);
            }

            menuOutput.showResult((new Double(determinan)).toString());
        } else {
            System.out.println(terminalColor.TEXT_CYAN+"Matriks haruslah berupa matriks persegi."+terminalColor.TEXT_RESET);
        }
    }
}
