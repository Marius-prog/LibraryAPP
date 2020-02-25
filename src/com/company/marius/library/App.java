package com.company.marius.library;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            String initialMenuOptions = "Press: \n"
                    + "\t- 1: librarian menu\n"
                    + "\t- 2: user menu\n"
                    + "\t- q: quit the program\n";
            System.out.println(initialMenuOptions);
            choice = sc.nextLine();

            switch (choice) {
                case "1":
                    handleLibrarian(sc);
                    break;
                case "2":
                    handleUser(sc);
                    break;
                case "q":
                    System.out.println("bye bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("incorrect value entered !!");
                    System.out.println("repeat pleace !!");


            }

        }while (true);
    }

    private static void handleUser(Scanner sc) {
        System.out.println("yes");


    }

    private static void handleLibrarian(Scanner sc) {


    }


}
