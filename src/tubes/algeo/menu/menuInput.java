package tubes.algeo.menu;

import tubes.algeo.lib.IO;
import tubes.algeo.lib.type.Matriks;
import tubes.algeo.lib.type.Node;
import tubes.algeo.lib.util.terminalColor;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class menuInput {
    public static Matriks getMatriks(String operasi)  {
        while(true){
            Scanner source = new Scanner(System.in);
            Scanner file = new Scanner(System.in);

            try{
                int pilihan = ShowTitle(operasi);
                if(pilihan < 1 || pilihan > 2){
                    System.out.println("** Pilihan yang tersedia hanya dari 1 sampai dengan 2 **");
                    System.out.print("**** Silahkan tekan enter untuk melanjutkan program ****");
                    try{
                        System.in.read();
                    }catch(Exception ignored){
                    }
                }else{
                    Matriks res = new Matriks();

                    switch (pilihan){
                        case 1:{
                            System.out.print("Masukkan path file input: ");
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
                System.out.println(terminalColor.TEXT_RED +"Oopss..");
                System.out.println("Terjadi Eksepsi saat melakukan pembacaan data. \n" + terminalColor.TEXT_RESET);
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

    private static int ShowTitle(String operasi) throws InputMismatchException {
        System.out.println(" ");
        System.out.println("================================================================");
        System.out.println("****************************************************************");
        System.out.println("Operasi yang dipilih : " + operasi);
        System.out.println("\nSilahkan pilih mode membaca data yg diinginkan:");
        System.out.println("1. Baca dari File");
        System.out.println("2. Baca dari Konsol");
        System.out.println("****************************************************************");
        System.out.println("================================================================");
        System.out.print("Masukkan pilihan Anda: ");
        Scanner source = new Scanner(System.in);

        return source.nextInt();
    }

    public int getMethod(String operasi){
        while(true){
            Scanner source = new Scanner(System.in);

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

                if(pilihan < 1 || pilihan > 4){
                    System.out.println("** Pilihan yang tersedia hanya dari 1 sampai dengan 2 **");
                    System.out.print("**** Silahkan tekan enter untuk melanjutkan program ****");
                    try{
                        System.in.read();
                    }catch(Exception ignored){
                    }
                }
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
                System.out.println(terminalColor.TEXT_RED +"Oopss..");
                System.out.println("Terjadi Eksepsi saat melakukan pembacaan data. \n" + terminalColor.TEXT_RESET);
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

    public Node[] getNodes(String operasi){
        while(true){
            Scanner source = new Scanner(System.in);
            Scanner file = new Scanner(System.in);

            try{
                int pilihan = ShowTitle(operasi);
                if(pilihan < 1 || pilihan > 2) {
                    System.out.println("** Pilihan yang tersedia hanya dari 1 sampai dengan 2 **");
                    System.out.print("**** Silahkan tekan enter untuk melanjutkan program ****");
                    try{
                        System.in.read();
                    }catch(Exception ignored){
                    }
                }
                else{
                   Node[] res = {};

                    switch (pilihan){
                        case 1:{
                            System.out.print("Masukkan path file input: ");
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
                System.out.println(terminalColor.TEXT_RED +"Oopss..");
                System.out.println("Terjadi Eksepsi saat melakukan pembacaan data. \n" + terminalColor.TEXT_RESET);
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
}
