package tubes.algeo.menu;

import tubes.algeo.lib.type.Matriks;

import java.util.Scanner;
import java.util.InputMismatchException;

public class mainMenu {

    public static Scanner source = new Scanner(System.in);
    public static Scanner file = new Scanner(System.in);
    public static Scanner inputFile = new Scanner(System.in);
    public static Matriks input;
    public static double resultOfDeterminant;
    public static int methodeOfDeterminant;

    public static void main(String[] args) {
        menuUtama();
    }

    private static void menuUtama() {
        while (true) {
            try {
                int pilihan;
                System.out.println(" ");
                System.out.println("~~~~~~~ Selamat Datang di Program Matrix Java Kelompok DelTa ~~~~~~~~");
                System.out.println("Program ini berisi sistem-sistem penggunaan matrix dengan bahasa java");
                System.out.println("=====================================================================");
                System.out.println(" ");
                System.out.println("*********************************************************************");
                System.out.println("=============================== MENU ================================");
                System.out.println("1). Sistem Persamaan Linier");
                System.out.println("2). Determinan");
                System.out.println("3). Matriks balikan");
                System.out.println("4). Interpolasi Polinom");
                System.out.println("5). Regresi linier berganda");
                System.out.println("6). Keluar");
                System.out.println("=====================================================================");
                System.out.println("*********************************************************************");
                System.out.println(" ");
                System.out.print("Masukkan pilihan anda: ");
                pilihan = source.nextInt();
                if (pilihan < 1 || pilihan > 6) throw new Exception();
                else {
                    switch (pilihan) {
                        case 1: {
                            new menuSPL(); //perlu beberapa sub menu
                            break;
                        }
                        case 2: {
                            new menuDeterminan(); //perlu beberapa sub menu
                            break;
                        }
                        case 3: {
                            new menuInverse(); //perlu beberapa sub menu
                            break;
                        }
                        case 4: {
                            new menuInterpolasi(); //tanpa sub menu
                            break;
                        }
                        case 5: {
                            new menuRegresi(); //tanpa sub menu
                            break;
                        }
                        case 6: {
                            System.exit(0); // langsung keluar
                            break;
                        }
                    }
                    menuUtama();
                }
            } catch(InputMismatchException e){
                source.next();
                System.out.println("******* Masukan yang benar adalah sebuah angka *******");
                System.out.print("**** Silahkan tekan enter untuk melanjutkan program ****");
                try{
                    System.in.read();
                } catch(Exception exKey){}
                menuUtama();
                return;

            } catch (Exception e) {
                System.out.println("** Pilihan yang tersedia hanya dari 1 sampai dengan 6 **");
                System.out.print("**** Silahkan tekan enter untuk melanjutkan program ****");
                try {
                    System.in.read();
                } catch (Exception exKey) {
                }
                menuUtama();
                return;
            }
        }
    }
}
