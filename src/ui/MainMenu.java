package ui;

import java.util.Scanner;

public class MainMenu {

    public static void drawMainOptions() {
        boolean t = true;

        try (Scanner scanner = new Scanner(System.in)) {

            while (t) {

                try {
                    System.out.println("\n");
                    System.out.println("Welcome to the Hotel Reservation Application");
                    System.out.println("-------------------------------------------------------");
                    System.out.println("1. Find and reserve a room");
                    System.out.println("2. See my reservations");
                    System.out.println("3. Create an Account");
                    System.out.println("4. Admin");
                    System.out.println("5. Exit");
                    System.out.println("-------------------------------------------------------");
                    System.out.println("Please enter an option number: ");
                    int option = Integer.parseInt(scanner.nextLine());

                    switch (option) {
                        case 1 -> {
                            System.out.println("This is option 1");
                            t = false;
                        }
                        case 2 -> {
                            System.out.println("This is option 2");

                            t = false;
                        }
                        case 3 -> {

                            t = false;
                        }
                        case 4 -> {
                            System.out.println("This is option 4");
                            AdminMenu.drawAdminOptions();
                            t = false;
                        }
                        case 5 -> {
                            System.out.println("The application will end now");
                            System.exit(-1);
                        }
                        default -> System.out.println("Please select a correct option from 1 to 5");
                    }
                } catch (NumberFormatException e) {

                    System.out.println("ERROR! Please enter a valid option number." + "\n");


                }


            }


        }


    }
}
