package tubes.algeo.menu;

import tubes.algeo.lib.IO;
import tubes.algeo.lib.type.Matriks;
import tubes.algeo.lib.type.Node;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class menuInput {
    public static Scanner source = new Scanner(System.in);
    public static Scanner file = new Scanner(System.in);

    public static Matriks getMatriks(String operasi)  {
        while(true){
            try{
                int pilihan;
                System.out.println(" ");
                System.out.println("================================================================");
                System.out.println("****************************************************************");
                System.out.println("Menu Input " + operasi);
                System.out.println("1. Baca dari File");
                System.out.println("2. Baca dari Konsol");
                System.out.println("****************************************************************");
                System.out.println("================================================================");
                System.out.print("Masukkan pilihan Anda: ");
                pilihan = source.nextInt();
                if(pilihan < 1 || pilihan > 2) throw new Exception();
                else{
                    Matriks res = new Matriks();

                    switch (pilihan){
                        case 1:{
                            System.out.print("Masukkan nama File tanpa ekstensi: ");
                            String fileNama =  file.nextLine();
                            res = IO.readFileMatriks(fileNama);
                            break;
                        }
                        case 2:{
                            res = IO.readMatrix();
                            break;
                        }
                    }

                    return res;
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

    public int getMethod(String operasi){
        while(true){
            try{
                int pilihan;
                System.out.println(" ");
                System.out.println("================================================================");
                System.out.println("****************************************************************");
                System.out.println("Menu Input " + operasi);
                System.out.println("1. Metode Eliminasi Gauss");
                System.out.println("2. Metode Eliminasi Gauss-Jordan");
                System.out.println("3. Metode Matriks balikan");
                System.out.println("4. Kaidah Cramer");
                System.out.println("****************************************************************");
                System.out.println("================================================================");
                System.out.print("Masukkan pilihan Anda: ");

                pilihan = source.nextInt();

                if(pilihan < 1 || pilihan > 4) throw new Exception();
                else{
                    return pilihan;
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

    public Node[] getNodes(String operasi){
        while(true){
            try{
                int pilihan;
                System.out.println(" ");
                System.out.println("================================================================");
                System.out.println("****************************************************************");
                System.out.println("Menu Input " + operasi);
                System.out.println("1. Baca dari File");
                System.out.println("2. Baca dari Konsol");
                System.out.println("****************************************************************");
                System.out.println("================================================================");
                System.out.print("Masukkan pilihan Anda: ");
                pilihan = source.nextInt();
                if(pilihan < 1 || pilihan > 2) throw new Exception();
                else{
                   Node[] res = {};

                    switch (pilihan){
                        case 1:{
                            System.out.print("Masukkan nama File tanpa ekstensi: ");
                            String fileNama =  file.nextLine();
                            res = IO.readFileNodes(fileNama);
                            break;
                        }
                        case 2:{
                            res = IO.readNodes();
                            break;
                        }
                    }

                    return res;
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
}
