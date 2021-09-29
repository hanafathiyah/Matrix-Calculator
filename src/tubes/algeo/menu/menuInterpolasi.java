package tubes.algeo.menu;
import tubes.algeo.lib.Interpolasi;
import tubes.algeo.lib.error.InterpolasiException;
import tubes.algeo.lib.type.LinearFunction;
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

        Node[] data = menuInput.getNodes1("Interpolasi", "Masukan data yang akan diinterpolasikan");

        try{
            Polynomial pl = Interpolasi.getFunction(data);

            boolean done = false;
            while (!done){
              String[] aksi = {"Menampilkan fungsi hasil interpolasi", "Menghitung prakiraan data", "Kembali ke menu utama"};
              int pilihanAksi = menuInput.pilihanOpsi(aksi, "Masukan aksi yang ingin anda lakukan");

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
                System.out.println(terminalColor.TEXT_RED +"Oopss..");
                System.out.println("Terjadi Kesalahan saat melakukan interpolasi. \n" + terminalColor.TEXT_RESET);
                System.out.println("Detail Kesalahan: ");
                System.out.println(e.getMessage());

                System.out.print("\n**** Silahkan tekan enter untuk melanjutkan program ****");
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
