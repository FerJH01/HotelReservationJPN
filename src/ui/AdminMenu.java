package ui;

import api.AdminResource;

import java.util.Scanner;

import static ui.MainMenu.drawMainOptions;

public class AdminMenu {

    public static void drawAdminOptions() {
        boolean t = true;

        try (Scanner scanner = new Scanner(System.in)) {

            while (t) {

                try {
                    System.out.println("-------------------------------------------------------");
                    System.out.println("1. See all Customers");
                    System.out.println("2. See all Rooms");
                    System.out.println("3. See all Reservations");
                    System.out.println("4. Add a Room");
                    System.out.println("5. Add Test Data / found customer by email");
                    System.out.println("6. Back to the Main Menu");
                    System.out.println("-------------------------------------------------------");

                    int option = Integer.parseInt(scanner.nextLine());

                    switch (option) {
                        case 1:

                            drawAdminOptions();

                            t = false;
                            break;
                        case 2:
                            System.out.println("This is option 2");
                            t = false;
                            break;
                        case 3:
                            System.out.println("This is option 3");
                            t = false;
                            break;
                        case 4:
                            System.out.println("This is option 4");
                            t = false;
                            break;
                        case 5:
                            System.out.println("This is option 5");
                            t = false;
                            break;
                        case 6:
                            System.out.println("This is option 6");
                            t = false;
                            drawMainOptions();

                        default:
                            System.out.println("Please select a an option from 1 to 6");
                            drawAdminOptions();
                    }
                } catch (NumberFormatException e) {

                    System.out.println("ERROR! Please enter a valid option number." + "\n");
                }
            }
        }
    }
}
