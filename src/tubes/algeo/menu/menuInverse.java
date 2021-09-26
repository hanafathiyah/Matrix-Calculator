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
        Matriks input = IO.readMatrix();
        if (input.isSquare()) {
            Matriks inverse = input.inverseByKofaktor();
            System.out.println("Inverse matriks tersebut adalah");
            for(int i = 0; i < inverse.getNRows(); i++) {
                for(int j = 0; j < inverse.getNCols(); j++) {
                    System.out.print(inverse.getElmt(i,j));
                    if(j < inverse.getNCols() - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println("");
            }
        } else {
            System.out.println("Matriks harus persegi.");
        }
    }
}
