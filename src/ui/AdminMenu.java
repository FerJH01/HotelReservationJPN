package ui;

import api.AdminResource;
import model.IRoom;
import model.Room;
import model.RoomType;
import service.ReservationService;

import java.util.*;

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
                            seeAllRooms();
                            drawAdminOptions();
                            t = false;
                            break;
                        case 3:
                            System.out.println("This is option 3");
                            t = false;
                            break;
                        case 4:

                            addARoom();
                            drawAdminOptions();
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
    public static void seeAllRooms(){

        Collection<IRoom> rooms;
        rooms = AdminResource.getAllRooms();

    if(rooms.isEmpty()){

        System.out.println("There are no rooms to display at the moment");

    } else {
        for(IRoom room: rooms) {

            System.out.println(room);
        }

        }

    }

    public static void seeAllReservations(){}

    public static void addARoom(){

        List<IRoom> rooms = new ArrayList<IRoom>();

         String roomNumber;
         Double price = null;
         String keepAdding;
         boolean t = false;
         int type;
         RoomType roomType = null;
         Scanner scanner = new Scanner(System.in);


            do {
                do {

                    System.out.println("Please enter a Room number: ");
                    roomNumber = scanner.nextLine();

                } while (roomNumber.isBlank());


                do {
                    System.out.println("Please enter a Room price: ");

                    try {
                        price = scanner.nextDouble();
                        t = false;

                    } catch (InputMismatchException ex) {

                        System.out.println("ERROR! No valid price was entered");

                        t = true;

                        scanner.next();
                    }
                } while (t);

                do {
                    System.out.println("Please enter the type of room: 1 - Single bed, 2 - Double Bed");
                    type = scanner.nextInt();

                    if (type == 1) {

                        roomType = RoomType.SINGLE;

                    } else if (type == 2) {

                        roomType = RoomType.DOUBLE;
                    } else {

                        System.out.println("Please enter 1 for Single Bed rooms or 2 for Double Bed");
                    }

                } while (type != 1 && type != 2);

                IRoom room = new Room(roomNumber, price, roomType);
                rooms.add(room);

                do {
                    System.out.println("Add another Room? Y/N: ");
                    keepAdding = scanner.next().toLowerCase().trim();
                } while (!keepAdding.equals("y") && !keepAdding.equals("n"));

            }while(keepAdding.equals("y"));

            AdminResource.addRoom(rooms);


    }







    //optional
    public static void addTestData(){
        //method that Admin can use to add customers / rooms and reservations as test

    }
}
