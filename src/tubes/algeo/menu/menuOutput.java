package tubes.algeo.menu;

import tubes.algeo.lib.IO;
import tubes.algeo.lib.type.LinearFunction;
import tubes.algeo.lib.type.Matriks;
import tubes.algeo.lib.type.SPLResult;

import java.util.InputMismatchException;
import java.util.Scanner;

public class menuOutput {
  public static Scanner source = new Scanner(System.in);
  public static Scanner file = new Scanner(System.in);

  static void showResult(String str){
      while(true){
            try{
                int pilihan;
                System.out.println(" ");
                System.out.println("Pilih mode menampilkan solusi:");
                System.out.println("1. Baca dari File");
                System.out.println("2. Baca dari Konsol\n");
                System.out.print("Masukkan pilihan Anda: ");

                pilihan = source.nextInt();
                if(pilihan < 1 || pilihan > 2) throw new Exception();
                else{

                    switch (pilihan){
                        case 1:{
                            System.out.print("Masukkan path penyimpanan file : ");
                            String fileNama =  file.nextLine();
                            IO.writeTextFile(fileNama, str);
                            break;
                        }
                        case 2:{
                            System.out.println("\n Solusi :");
                            System.out.println(str);
                            break;
                        }
                    }

                }
            }
            catch(InputMismatchException e){
                source.next();
                System.out.println("******* Masukan yang benar adalah sebuah angka *******");
                System.out.print("**** Silahkan tekan enter untuk melanjutkan program ****");
                try{
                    System.in.read();
                }catch(Exception ignored){
                }
            }
            catch(Exception e){
                System.out.println("** Pilihan yang tersedia hanya dari 1 sampai dengan 2 **");
                System.out.print("**** Silahkan tekan enter untuk melanjutkan program ****");
                try{
                    System.in.read();
                }catch(Exception ignored){
                }
            }
        }
    }

    static void showMatriksResult(Matriks mat){
      showResult(mat.getMatriksStr());
    }

    static void showSPLDefinitonResult(SPLResult result){
      showResult(result.getStrResult());
    }

    static void showSPLMatriksResult(SPLResult result){
      showResult(result.getMatriksStr());
    }

    static void showLinearFuncDefinition(LinearFunction res){
      showResult(res.getStrResult());
    }
}
