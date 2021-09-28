package tubes.algeo.menu;
import tubes.algeo.lib.Regresi;
import tubes.algeo.lib.error.RegresiException;
import tubes.algeo.lib.type.LinearFunction;
import tubes.algeo.lib.type.Node;
import tubes.algeo.lib.util.terminalColor;

import java.util.Scanner;

public class menuRegresi {
    public static void menu(){
        menuregresi();
    }
    public static void  menuregresi() {
        System.out.println(terminalColor.TEXT_WHITE + "\n" +
                "██████  ███████  ██████  ██████  ███████ ███████ ██ \n" +
                "██   ██ ██      ██       ██   ██ ██      ██      ██ \n" +
                "██████  █████   ██   ███ ██████  █████   ███████ ██ \n" +
                "██   ██ ██      ██    ██ ██   ██ ██           ██ ██ \n" +
                "██   ██ ███████  ██████  ██   ██ ███████ ███████ ██ \n" +
                "                                                    \n" +
                "                                                    \n" + terminalColor.TEXT_RESET);

        Node[] data = menuInput.getNodes("Regresi", "Masukan data yang akan dihitung regresinya");
        try{
            LinearFunction lf = Regresi.getFunction(data);

            boolean done = false;
            while (!done){
              String[] aksi = {"Menampilkan persamaan regresi", "Menghitung prakiraan data", "Kembali ke menu utama"};
              int pilihanAksi = menuInput.pilihanOpsi(aksi, "Masukan aksi yang ingin anda lakukan");

              switch (pilihanAksi){
                case 1:
                  menuOutput.showLinearFuncDefinition(lf);
                  break;
                case 2:
                  hitungPrakiraanData(lf);
                  break;
                case 3:
                  done = true;
                  break;
              }
            }

        }catch (RegresiException e){
                System.out.println(terminalColor.TEXT_RED +"Oopss..");
                System.out.println("Terjadi Kesalahan saat melakukan regresi. \n" + terminalColor.TEXT_RESET);
                System.out.println("Detail Kesalahan: ");
                System.out.println(e.getMessage());

                System.out.print("\n**** Silahkan tekan enter untuk melanjutkan program ****");
                try{
                    System.in.read();
                }catch(Exception ignored){
                }
        }
    }

    static void hitungPrakiraanData(LinearFunction lf) {
      System.out.println(terminalColor.TEXT_CYAN + "\n*** Menghitung nilai dari hasil regresi ***" + terminalColor.TEXT_RESET);
      System.out.println("Masukkan nilai variabel: ");

      double[] data = new double[lf.getVariableNumber()];
      Scanner s = new Scanner(System.in);

      for(int i = 0; i < lf.getVariableNumber(); i++){
        data[i] = s.nextDouble();
      }

      try {
        double res = lf.calculate(data);
        menuOutput.showResult((new Double(res)).toString());
      }catch (Exception e){
          System.out.println(terminalColor.TEXT_RED +"Oopss..");
          System.out.println("Terjadi Kesalahan saat melakukan perhitungan. \n" + terminalColor.TEXT_RESET);
          System.out.println("Detail Kesalahan: ");
          System.out.println(e.getMessage());

          System.out.print("\n**** Silahkan tekan enter untuk melanjutkan program ****");
          try{
              System.in.read();
          }catch(Exception ignored){
          }
      }

    }
}
