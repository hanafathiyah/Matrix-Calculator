package tubes.algeo.menu;
import tubes.algeo.lib.IO;
import tubes.algeo.lib.type.Matriks;
import tubes.algeo.lib.util.terminalColor;
public class menuInverse {
    public static void menu(){
        menuinverse();
    }
    public static void  menuinverse() {
        System.out.println(terminalColor.TEXT_RED + "\n" +
                "██ ███    ██ ██    ██ ███████ ██████  ███████ ███████ \n" +
                "██ ████   ██ ██    ██ ██      ██   ██ ██      ██      \n" +
                "██ ██ ██  ██ ██    ██ █████   ██████  ███████ █████   \n" +
                "██ ██  ██ ██  ██  ██  ██      ██   ██      ██ ██      \n" +
                "██ ██   ████   ████   ███████ ██   ██ ███████ ███████ \n" +
                "                                                      \n" +
                "                                                      \n"+ terminalColor.TEXT_RESET);
        Matriks input = menuInput.getMatriks("Matriks Balikan", "Masukan matriks yang ingin dicari balikannya");
        if (input.isSquare()) {
            Matriks inverse = input.inverseByKofaktor();
            menuOutput.showMatriksResult(inverse);
        } else {
            System.out.println("Matriks harus persegi.");
        }

        if (input.isSquare()) {
            String[] metode = {"Metode OBE", "Metode Kofaktor"};
            Matriks inverse;

            int pilihan = menuInput.pilihanOpsi(metode, "Pilih metode perhitungan yang diinginkan");
            switch (pilihan){
                case 1:
                    inverse = input.inverseByAugmented();
                    break;
                case 2:
                    inverse = input.inverseByKofaktor();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + pilihan);
            }

            menuOutput.showMatriksResult(inverse);
        } else {
            System.out.println("Matriks haruslah berupa matriks persegi.");
        }

    }
}
