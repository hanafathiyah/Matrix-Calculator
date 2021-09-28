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
    }
}
