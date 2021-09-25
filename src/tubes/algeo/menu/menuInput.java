package tubes.algeo.menu;

import tubes.algeo.lib.type.Matriks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class menuInput {
    public static Scanner source = new Scanner(System.in);
    public static Matriks input;
    public static Scanner file = new Scanner(System.in);
    public static double resultofDeterminan;

    public static void  menuinput(String operasi){
        while(true){
            try{
                int pilihan;
                System.out.println(" ");
                System.out.println("================================================================");
                System.out.println("****************************************************************");
                System.out.println("Menu Input " + operasi);
                System.out.println("1. Baca dari File");
                System.out.println("2. Baca dari Konsol");
                System.out.println("3. Back to Main Menu");
                System.out.println("4. Keluar");
                System.out.println("****************************************************************");
                System.out.println("================================================================");
                System.out.print("Masukkan pilihan Anda: ");
                pilihan = source.nextInt();
                if(pilihan < 1 || pilihan > 4) throw new Exception();
                else{
                    input = new Matriks();
                    resultofDeterminan = 0.0;
                    switch (pilihan){
                        case 1:{
                            System.out.print("Masukkan nama File tanpa ekstensi: ");
                            String fileNama =  file.nextLine();
                            switch(operasi){
                                case "SPL":{
                                    new mainMenu();
                                }
                                case "Determinan":{
                                    new mainMenu();
                                }
                                case "Matriks Balikan":{
                                    new mainMenu();
                                }
                                case "Interpolasi Polinom":{
                                    new mainMenu();
                                }
                                case "Regresi Linier Berganda":{
                                    new menuRegresi();
                                }
                            }
                            break;
                        }
                        case 2:{
                            switch(operasi){
                                case "SPL":{
                                    new mainMenu();
                                }
                                case "Determinan":{
                                    new mainMenu();
                                }
                                case "Matriks Balikan":{
                                    new mainMenu();
                                }
                                case "Interpolasi Polinom":{
                                    new mainMenu();
                                }
                                case "Regresi Linier Berganda":{
                                    new mainMenu();
                                }
                            }
                            break;
                        }
                        case 3:{
                            new mainMenu();
                            break;
                        }

                        case 4:{
                            System.exit(0);
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
                } catch(Exception exKey){}
                menuinput(operasi);
                return;
            }
            catch(Exception e){
                System.out.println("** Pilihan yang tersedia hanya dari 1 sampai dengan 4 **");
                System.out.print("**** Silahkan tekan enter untuk melanjutkan program ****");
                try{
                    System.in.read();
                } catch(Exception exKey){}
                menuinput(operasi);
                return;
            }
            return;
        }
    }
}
