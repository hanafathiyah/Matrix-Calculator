package tubes.algeo.menu;

import tubes.algeo.lib.IO;
import tubes.algeo.lib.type.LinearFunction;
import tubes.algeo.lib.type.Matriks;
import tubes.algeo.lib.type.SPLResult;
import tubes.algeo.lib.util.terminalColor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class menuOutput {

  static void showResult(String str){
      boolean isFinished = false;

      while(!isFinished){
            Scanner source = new Scanner(System.in);
            Scanner file = new Scanner(System.in);

            try{
                int pilihan;
                System.out.println(" ");
                System.out.println("Pilih mode menampilkan solusi:");
                System.out.println("1. Simpan pada File");
                System.out.println("2. Tampilkan pada layar\n");
                System.out.print("Masukkan pilihan Anda: ");

                pilihan = source.nextInt();
                if(pilihan < 1 || pilihan > 2){
                    System.out.println("** Pilihan yang tersedia hanya dari 1 sampai dengan 2 **");
                    System.out.print("**** Silahkan tekan enter untuk melanjutkan program ****");
                    try{
                        System.in.read();
                    }catch(Exception ignored){
                    }
                } else{
                    switch (pilihan){
                        case 1:{
                            System.out.print("Masukkan path penyimpanan file : ");
                            String fileNama =  file.nextLine();
                            IO.writeTextFile(fileNama, str);
                            isFinished = true;

                            break;
                        }
                        case 2:{
                            System.out.println("\nSolusi :");
                            System.out.println(str);
                            isFinished = true;

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
                System.out.println(terminalColor.TEXT_RED +"Oopss..");
                System.out.println("Terjadi Eksepsi saat melakukan pembacaan data. \n" + terminalColor.TEXT_RESET);
                System.out.println("Detail Kesalahan: ");
                System.out.println(e.getMessage());
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
