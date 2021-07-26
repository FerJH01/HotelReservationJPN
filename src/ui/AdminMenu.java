package ui;

import api.AdminResource;
import model.RoomType;

import java.util.InputMismatchException;
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

                            seeAllCustomers();
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
                            addARoom();
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



    public static void seeAllCustomers() {

        if (AdminResource.getAllCustomer() != null) {
            System.out.println(AdminResource.getAllCustomer());

        } else {

            System.out.println("There aren't customers to show at the moment");
        }
    }
    public static void seeAllRooms(){}

    public static void seeAllReservations(){}

    public static void addARoom(){

         String roomNumber;
         Double price;
         RoomType enumeration;
         Scanner scanner = new Scanner(System.in);

         do {

                 System.out.println("Please enter a Room number: ");
                 roomNumber = scanner.nextLine();

         }while(roomNumber.isBlank());

        boolean t;

        do {
            System.out.println("Please enter a Room price: ");

            try {
                    price = scanner.nextDouble();
                    t = false;

            } catch (InputMismatchException ex) {

                System.out.println("Please enter a valid price.");
                t = true;
            }

        }while(t);






    }

    //optional
    public static void addTestData(){
        //method that Admin can use to add customers / rooms and reservations as test

    }
}
