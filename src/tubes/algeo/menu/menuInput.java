package tubes.algeo.menu;

import tubes.algeo.lib.IO;
import tubes.algeo.lib.type.Matriks;
import tubes.algeo.lib.type.Node;
import tubes.algeo.lib.util.terminalColor;

import java.io.IOException;
import java.security.PublicKey;
import java.util.InputMismatchException;
import java.util.Scanner;

public class menuInput {
    public static Matriks getMatriks(String operasi, String petunjuk)  {
        while(true){
            Scanner source = new Scanner(System.in);
            Scanner file = new Scanner(System.in);

            try{
                int pilihan = ShowTitle(operasi, petunjuk);
                if(pilihan < 1 || pilihan > 2){
                    System.out.println(terminalColor.TEXT_CYAN+"** Pilihan yang tersedia hanya dari 1 sampai dengan 2 **");
                    System.out.print("**** Silahkan tekan enter untuk melanjutkan program ****"+terminalColor.TEXT_RESET);
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
                System.out.println(terminalColor.TEXT_RED+"******* Masukan yang benar adalah sebuah angka *******"+terminalColor.TEXT_RESET);
                System.out.print(terminalColor.TEXT_CYAN+"**** Silahkan tekan enter untuk melanjutkan program ****"+terminalColor.TEXT_RESET);
                try{
                    System.in.read();
                }catch(Exception ignored){
                }
            }
            catch(Exception e){
                System.out.println(terminalColor.TEXT_RED +"Oopss..");
                System.out.println("Terjadi Eksepsi saat melakukan pembacaan data. \n" + terminalColor.TEXT_RESET);
                System.out.println(terminalColor.TEXT_PURPLE+"Detail Kesalahan: "+terminalColor.TEXT_RESET);
                System.out.println(e.getMessage());

                System.out.print(terminalColor.TEXT_CYAN+"\n**** Silahkan tekan enter untuk melanjutkan program ****"+terminalColor.TEXT_RESET);
                try{
                    System.in.read();
                }catch(Exception ignored){
                }
            }
        }
    }

    private static int ShowTitle(String operasi, String petunjuk) throws InputMismatchException {
        System.out.println(" ");
        System.out.println(terminalColor.TEXT_BLUE+"================================================================"+terminalColor.TEXT_RESET);
        System.out.println(terminalColor.TEXT_RED+"****************************************************************"+terminalColor.TEXT_RESET);
        System.out.println("Operasi yang dipilih : " + operasi);
        System.out.println(terminalColor.TEXT_GREEN+"\nPetunjuk : "+terminalColor.TEXT_RESET);
        System.out.println(petunjuk);
        System.out.println(terminalColor.TEXT_RED+"\nSilahkan pilih mode membaca data yg diinginkan:"+terminalColor.TEXT_RESET);
        System.out.println("1. Baca dari File");
        System.out.println("2. Baca dari Konsol");
        System.out.println(terminalColor.TEXT_RED+"****************************************************************"+terminalColor.TEXT_RESET);
        System.out.println(terminalColor.TEXT_BLUE+"================================================================"+terminalColor.TEXT_RESET);
        System.out.print("Masukkan pilihan Anda: ");
        Scanner source = new Scanner(System.in);

        return source.nextInt();
    }

    public static final int METHOD_ELIMINASI_GAUSS = 1;
    public static final int METHOD_ELIMINASI_GAUSS_JORDAN = 2;
    public static final int METHOD_INVERSE = 3;
    public static final int METHOD_CRAMER = 4;

    public static int getMethod(String operasi){
        while(true){
            Scanner source = new Scanner(System.in);

            try{
                int pilihan;
                System.out.println(" ");
                System.out.println(terminalColor.TEXT_BLUE+"================================================================"+terminalColor.TEXT_RESET);
                System.out.println(terminalColor.TEXT_RED+"****************************************************************"+terminalColor.TEXT_RESET);
                System.out.println(terminalColor.TEXT_PURPLE+ "Menu Input " + operasi+terminalColor.TEXT_RESET);
                System.out.println("1. Metode Eliminasi Gauss");
                System.out.println("2. Metode Eliminasi Gauss-Jordan");
                System.out.println("3. Metode Matriks balikan");
                System.out.println("4. Kaidah Cramer");
                System.out.println(terminalColor.TEXT_RED+"****************************************************************"+terminalColor.TEXT_RESET);
                System.out.println(terminalColor.TEXT_BLUE+"================================================================"+terminalColor.TEXT_RESET);
                System.out.print("Masukkan pilihan Anda: ");

                pilihan = source.nextInt();

                if(pilihan < 1 || pilihan > 4){
                    System.out.println(terminalColor.TEXT_CYAN+"** Pilihan yang tersedia hanya dari 1 sampai dengan 2 **");
                    System.out.print("**** Silahkan tekan enter untuk melanjutkan program ****"+terminalColor.TEXT_RESET);
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
                System.out.println(terminalColor.TEXT_RED+"******* Masukan yang benar adalah sebuah angka *******"+terminalColor.TEXT_RESET);
                System.out.print(terminalColor.TEXT_CYAN+"**** Silahkan tekan enter untuk melanjutkan program ****"+terminalColor.TEXT_RESET);
                try{
                    System.in.read();
                }catch(Exception ignored){
                }
            }
            catch(Exception e){
                System.out.println(terminalColor.TEXT_RED +"Oopss.."+terminalColor.TEXT_RESET);
                System.out.println("Terjadi Eksepsi saat melakukan pembacaan data. \n" + terminalColor.TEXT_RESET);
                System.out.println(terminalColor.TEXT_BLUE+"Detail Kesalahan: "+terminalColor.TEXT_RESET);
                System.out.println(e.getMessage());

                System.out.print(terminalColor.TEXT_CYAN+"\n**** Silahkan tekan enter untuk melanjutkan program ****"+terminalColor.TEXT_RESET);
                try{
                    System.in.read();
                }catch(Exception ignored){
                }
            }
        }
    }

    public static Node[] getNodes1(String operasi, String petunjuk){
        while(true){
            Scanner source = new Scanner(System.in);
            Scanner file = new Scanner(System.in);

            try{
                int pilihan = ShowTitle(operasi, petunjuk);
                if(pilihan < 1 || pilihan > 2) {
                    System.out.println(terminalColor.TEXT_BLUE+"** Pilihan yang tersedia hanya dari 1 sampai dengan 2 **");
                    System.out.print("**** Silahkan tekan enter untuk melanjutkan program ****"+terminalColor.TEXT_RESET);
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
                            res = IO.readFileNodes1(fileNama);
                            break;
                        }
                        case 2:{
                            res = IO.readNodes1();
                            break;
                        }
                    }

                    return res;
                }
            }
            catch(InputMismatchException e){
                source.next();
                System.out.println(terminalColor.TEXT_RED+"******* Masukan yang benar adalah sebuah angka *******"+terminalColor.TEXT_RESET);
                System.out.print(terminalColor.TEXT_CYAN+"**** Silahkan tekan enter untuk melanjutkan program ****"+terminalColor.TEXT_RESET);
                try{
                    System.in.read();
                }catch(Exception ignored){
                }
            }
            catch(Exception e){
                System.out.println(terminalColor.TEXT_RED +"Oopss.."+terminalColor.TEXT_RESET);
                System.out.println("Terjadi Eksepsi saat melakukan pembacaan data. \n" + terminalColor.TEXT_RESET);
                System.out.println(terminalColor.TEXT_BLUE+"Detail Kesalahan: "+terminalColor.TEXT_RESET);
                System.out.println(e.getMessage());

                System.out.print(terminalColor.TEXT_CYAN+"\n**** Silahkan tekan enter untuk melanjutkan program ****"+terminalColor.TEXT_RESET);
                try{
                    System.in.read();
                }catch(Exception ignored){
                }
            }
        }
    }

    public static Node[] getNodes(String operasi, String petunjuk){
        while(true){
            Scanner source = new Scanner(System.in);
            Scanner file = new Scanner(System.in);

            try{
                int pilihan = ShowTitle(operasi, petunjuk);
                if(pilihan < 1 || pilihan > 2) {
                    System.out.println(terminalColor.TEXT_BLUE+"** Pilihan yang tersedia hanya dari 1 sampai dengan 2 **");
                    System.out.print("**** Silahkan tekan enter untuk melanjutkan program ****"+terminalColor.TEXT_RESET);
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
                System.out.println(terminalColor.TEXT_RED+"******* Masukan yang benar adalah sebuah angka *******"+terminalColor.TEXT_RESET);
                System.out.print(terminalColor.TEXT_CYAN+"**** Silahkan tekan enter untuk melanjutkan program ****"+terminalColor.TEXT_RESET);
                try{
                    System.in.read();
                }catch(Exception ignored){
                }
            }
            catch(Exception e){
                System.out.println(terminalColor.TEXT_RED +"Oopss.."+terminalColor.TEXT_RESET);
                System.out.println("Terjadi Eksepsi saat melakukan pembacaan data. \n" + terminalColor.TEXT_RESET);
                System.out.println(terminalColor.TEXT_BLUE+"Detail Kesalahan: "+terminalColor.TEXT_RESET);
                System.out.println(e.getMessage());

                System.out.print(terminalColor.TEXT_CYAN+"\n**** Silahkan tekan enter untuk melanjutkan program ****"+terminalColor.TEXT_RESET);
                try{
                    System.in.read();
                }catch(Exception ignored){
                }
            }
        }
    }

    public static int pilihanOpsi(String[] pilihan, String petunjuk){
        Scanner s = new Scanner(System.in);
        while (true){
            try{
                System.out.println(terminalColor.TEXT_BLUE+"\n================================================================"+terminalColor.TEXT_RESET);
                System.out.println("****************************************************************");
                System.out.println(petunjuk);
                System.out.println();

                for(int i = 0; i < pilihan.length; i++){
                    System.out.println((i + 1) + ". " + pilihan[i]);
                }

                System.out.print("Pilihan : ");

                int inputPilihan = s.nextInt();
                if(inputPilihan < 1 || inputPilihan > pilihan.length) {
                    System.out.println(terminalColor.TEXT_CYAN+"** Pilihan yang tersedia hanya dari 1 s.d. " + pilihan.length + " **" );
                    System.out.print("**** Silahkan tekan enter untuk melanjutkan program ****"+terminalColor.TEXT_RESET);
                    try{
                        System.in.read();
                    }catch(Exception ignored){
                    }
                }
                else{
                    return inputPilihan;
                }
            }
            catch(InputMismatchException e){
                s.next();
                System.out.println(terminalColor.TEXT_RED+"******* Masukan yang benar adalah sebuah angka *******"+terminalColor.TEXT_RESET);
                System.out.print(terminalColor.TEXT_CYAN+"**** Silahkan tekan enter untuk melanjutkan program ****"+terminalColor.TEXT_RESET);
                try{
                    System.in.read();
                }catch(Exception ignored){
                }
            }
            catch(Exception e) {
                System.out.println(terminalColor.TEXT_RED +"Oopss.."+terminalColor.TEXT_RESET);
                System.out.println("Terjadi Eksepsi saat melakukan pembacaan data. \n" + terminalColor.TEXT_RESET);
                System.out.println(terminalColor.TEXT_BLUE+"Detail Kesalahan: "+terminalColor.TEXT_RESET);
                System.out.println(e.getMessage());

                System.out.print(terminalColor.TEXT_CYAN+"\n**** Silahkan tekan enter untuk melanjutkan program ****"+terminalColor.TEXT_RESET);
                try {
                    System.in.read();
                } catch (Exception ignored) {
                }
            }
        }
    }
}
