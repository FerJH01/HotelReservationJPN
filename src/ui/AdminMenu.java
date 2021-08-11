package ui;

import api.AdminResource;
import api.HotelResource;
import model.FreeRoom;
import model.IRoom;
import model.Room;
import model.RoomType;
import service.ReservationService;

import java.util.*;
import java.util.regex.Pattern;

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
                            break;
                        case 2:
                            seeAllRooms();

                            break;
                        case 3:
                            seeAllReservations();

                            break;
                        case 4:
                            addRoom();

                            break;
                        case 5:
                            System.out.println("This is option 5");

                            break;
                        case 6:

                            MainMenu.drawMainOptions();

                        default:
                            System.out.println("Please select a an option from 1 to 6");

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

    public static void seeAllReservations(){

        AdminResource.displayAllReservations();

    }


    public static void addRoom(){
        Scanner input = new Scanner(System.in);
        List<IRoom> rooms = new ArrayList<IRoom>();
        Set<String> roomNumbers = new HashSet<>();

        final String emailRegex = "^[0-9]*$";
        final Pattern pattern = Pattern.compile(emailRegex);
        boolean incompatibleFormat = true;
        boolean repeatedRoomNumber = true;
        boolean repeatedRoomNumberAddedAlready = true;
        boolean priceMismatch;
        boolean typeMismatch = true;
        String keepAdding;
        String roomNumber;
        int repeated;
        double price = 0;
        RoomType roomType = null;
        int type = 0;
        int flag = 0;


do {
    do {
        Collection<IRoom> roomsAlreadyCreated = AdminResource.getAllRooms();
        repeated = 0;

        System.out.println("Please enter a Room number: ");
        roomNumber = input.nextLine();

        if (pattern.matcher(roomNumber).matches()) {

            incompatibleFormat = false;
            repeatedRoomNumber = roomNumbers.add(roomNumber);


        } else {

            System.out.println("Enter a correct room number");
        }

        for(IRoom rm : roomsAlreadyCreated){

            repeatedRoomNumberAddedAlready = rm.getRoomNumber().equals(roomNumber);

            if (repeatedRoomNumberAddedAlready){

                repeated++;
            }

            System.out.println(repeatedRoomNumberAddedAlready);
        }

        if(repeated!=0 || !repeatedRoomNumber){

            System.out.println("Repeated room numbers are not allowed");

        }

    } while (incompatibleFormat || !repeatedRoomNumber || repeated!=0);



    do {
        System.out.println("Please enter a Room price: ");

        try {
            price = input.nextDouble();
            priceMismatch = false;


        } catch (InputMismatchException ex) {

            System.out.println("ERROR! No valid price was entered");

            priceMismatch = true;

            input.next();
        }
    } while (priceMismatch);



    do {

        try {

            System.out.println("Please enter the type of room: 1 - Single bed, 2 - Double Bed");

            type = input.nextInt();

            typeMismatch = false;


            if (type == 1) {

                roomType = RoomType.SINGLE;

            } else if (type == 2) {


                roomType = RoomType.DOUBLE;


            } else {


                System.out.println("Please enter 1 for Single Bed rooms or 2 for Double Bed");

            }

        } catch (InputMismatchException ex) {


            System.out.println("This is not a valid input.");

            input.next();

        }

    } while(typeMismatch || type != 1 && type != 2);


    if(price == 0){

        IRoom room = new FreeRoom(roomNumber,price,roomType);

        rooms.add(room);

    } else {

        IRoom room = new Room(roomNumber, price, roomType);

        rooms.add(room);

    }


    do {
        System.out.println("Keep adding rooms? Y/N");
        keepAdding = input.nextLine().toLowerCase().trim();
    }while(!keepAdding.equals("y") && !keepAdding.equals("n"));



}while(keepAdding.equals("y"));


AdminResource.addRoom(rooms);


    }






    //optional
    public static void addTestData(){
        //method that Admin can use to add customers / rooms and reservations as test

    }
}
