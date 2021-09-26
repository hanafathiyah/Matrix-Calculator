package tubes.algeo.menu;
import tubes.algeo.lib.type.Matriks;
import tubes.algeo.lib.util.terminalColor;
import java.io.Console;
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
        bacamatriksdet();
    }
    public static void bacamatriksdet () {
        int baris, kolom;
        Matriks matriksdet = new Matriks();
        Console con = System.console();
        System.out.println("Masukkan ukuran matriks");
        System.out.print("Baris: ");
        baris = Integer.parseInt(con.readLine());
        System.out.print("Kolom: ");
        kolom = Integer.parseInt(con.readLine());
        for (int i = 0; i < baris; i++) {
            for(int j = 0; j < kolom; j++){
                int elmt = Integer.parseInt(con.readLine());
                matriksdet.setElmt(i,j,elmt);
            }
        }
        matriksdet.determinanByReduksi();
        // jujur saia bingung ini bacanya gimana tp saia ikhtiar dulu saja :"D
    }
}
