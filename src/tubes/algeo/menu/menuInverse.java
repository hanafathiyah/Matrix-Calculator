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
        Matriks input = menuInput.getMatriks(terminalColor.TEXT_BLUE+"Matriks Balikan", "Masukan matriks yang ingin dicari balikannya"+terminalColor.TEXT_RESET);

        if (input.isSquare()) {
            String[] metode = {terminalColor.TEXT_YELLOW+"Metode OBE", "Metode Kofaktor"+terminalColor.TEXT_RESET};
            Matriks inverse;
            if (input.determinanByKofaktor() == 0) {
                System.out.println(terminalColor.TEXT_RED+"Invers matriks tidak ada karena nilai determinan matriks sama dengan nol"+terminalColor.TEXT_RESET);
            } else {
                int pilihan = menuInput.pilihanOpsi(metode, "Pilih metode perhitungan yang diinginkan");
                switch (pilihan){
                    case 1:
                        inverse = input.inverseByAugmented();
                        break;
                    case 2:
                        inverse = input.inverseByKofaktor();
                        break;
                    default:
                        throw new IllegalStateException(terminalColor.TEXT_RED+"Unexpected value: " + pilihan+terminalColor.TEXT_RESET);
                }
                menuOutput.showMatriksResult(inverse);
            }
        } else {
            System.out.println(terminalColor.TEXT_CYAN+"Matriks haruslah berupa matriks persegi."+terminalColor.TEXT_RESET);
        }

    }
}
