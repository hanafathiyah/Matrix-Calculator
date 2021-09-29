package tubes.algeo.menu;
import tubes.algeo.lib.Interpolasi;
import tubes.algeo.lib.error.InterpolasiException;
import tubes.algeo.lib.type.Node;
import tubes.algeo.lib.type.Polynomial;
import tubes.algeo.lib.util.terminalColor;

import java.util.Scanner;

public class menuInterpolasi {
    public static void menu(){
        menuinterpolasi();
    }

    public static void  menuinterpolasi() {
        System.out.println(terminalColor.TEXT_YELLOW + "\n" +
                "██ ███    ██ ████████ ███████ ██████  ██████   ██████  ██       █████  ███████ ██ \n" +
                "██ ████   ██    ██    ██      ██   ██ ██   ██ ██    ██ ██      ██   ██ ██      ██ \n" +
                "██ ██ ██  ██    ██    █████   ██████  ██████  ██    ██ ██      ███████ ███████ ██ \n" +
                "██ ██  ██ ██    ██    ██      ██   ██ ██      ██    ██ ██      ██   ██      ██ ██ \n" +
                "██ ██   ████    ██    ███████ ██   ██ ██       ██████  ███████ ██   ██ ███████ ██ \n" +
                "                                                                                  \n" +
                "                                                                                  \n" + terminalColor.TEXT_RESET);

        Node[] data = menuInput.getNodes1(terminalColor.TEXT_GREEN+"Interpolasi", "Masukan data yang akan diinterpolasikan"+terminalColor.TEXT_RESET);

        try{
            Polynomial pl = Interpolasi.getFunction(data);

            boolean done = false;
            while (!done){
              String[] aksi = {terminalColor.TEXT_CYAN+"Menampilkan fungsi hasil interpolasi", "Menghitung prakiraan data", "Kembali ke menu utama"+terminalColor.TEXT_RESET};
              int pilihanAksi = menuInput.pilihanOpsi(aksi, "Masukan aksi yang ingin Anda lakukan");

              switch (pilihanAksi){
                case 1:
                  menuOutput.showResult(pl.getPolynomialStr());
                  break;
                case 2:
                  hitungPrakiraanData(pl);
                  break;
                case 3:
                  done = true;
                  break;
              }
            }

        }catch (InterpolasiException e){
            System.out.println(terminalColor.TEXT_RED +"Oopss.."+terminalColor.TEXT_RESET);
            System.out.println("Terjadi kesalahan saat melakukan interpolasi. \n" + terminalColor.TEXT_RESET);
            System.out.println(terminalColor.TEXT_BLUE+"Detail Kesalahan: "+terminalColor.TEXT_RESET);
            System.out.println(e.getMessage());


            System.out.print(terminalColor.TEXT_CYAN+"\n**** Silahkan tekan enter untuk melanjutkan program ****"+terminalColor.TEXT_RESET);
                try{
                    System.in.read();
                }catch(Exception ignored){
                }
        }
    }

    static void  hitungPrakiraanData(Polynomial pl){
        System.out.println(terminalColor.TEXT_CYAN + "*** Menghitung nilai prakiraan interpolasi ***" + terminalColor.TEXT_RESET);
        System.out.print("Nilai x : ");

        Scanner s = new Scanner(System.in);
        double x = s.nextDouble();

        double res = pl.calculate(x);
        menuOutput.showResult((new Double(res)).toString());
    }
}
