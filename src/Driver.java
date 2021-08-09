import api.AdminResource;
import api.HotelResource;
import model.*;
import ui.MainMenu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Driver {


    public static void main(String[] args) {
       MainMenu.drawMainOptions();

//        Scanner input = new Scanner(System.in);
//        Integer roomNumberToCast;
//        String roomNumber = null;
//        Set<Integer> listOfRoomNumbers = new HashSet<Integer>();
//        String keepAdding;
//
//        do{
//            System.out.println("Enter a Room number: ");
//            roomNumberToCast = input.nextInt();
//            listOfRoomNumbers.add(roomNumberToCast);
//
//            for(Integer nm : listOfRoomNumbers){
//
//                if(nm.equals(roomNumberToCast)){
//
//                    System.out.println("Room number already exist");
//
//                } else {
//
//                                listOfRoomNumbers.add(roomNumberToCast);
//                                roomNumber = String.valueOf(roomNumberToCast);
//                                System.out.println("Room added: " + roomNumber);
//
//
//                }
//
//            }
//
//
//
//
//            System.out.println("Enter another room? Y/N");
//            keepAdding = input.next().toLowerCase().trim();
//
//
//        }while(keepAdding.equals("y"));
//
//        Set<String> checkRepeatedRoomsFirstLoop = new HashSet<String>();
//        Scanner scanner = new Scanner(System.in);
//        String roomNumber;
//        boolean repeatedRoomNumber;
//
//        do {
//            System.out.println("Please enter a Room number: ");
//            roomNumber = scanner.nextLine();
//
//
//            checkRepeatedRoomsFirstLoop.add(roomNumber);
//
//            if (checkRepeatedRoomsFirstLoop. {
//
//                System.out.println(checkRepeatedRoomsFirstLoop);
//
//                repeatedRoomNumber = true;
//                System.out.println("repeated");
//            } else {
//
//                repeatedRoomNumber = false;
//                System.out.println("unique");
//                scanner.nextLine();
//            }
//
//        }while (repeatedRoomNumber);






        //     LocalDate currentLocalDate = LocalDate.now();
//        ZoneId defaultZoneId = ZoneId.systemDefault();
//        Date currentDate = Date.from(currentLocalDate.atStartOfDay(defaultZoneId).toInstant());
//        System.out.println(currentDate);








//
//        HotelResource.createACustomer("fer@gmail.com","fer", "hadad");
//        HotelResource.createACustomer("pepe@gmail.com","pepe", "joda");
//        HotelResource.createACustomer("yami@gmail.com","yami", "yami");
//
//        Customer cust = HotelResource.getCustomer("fer@mail.com");
//
//        System.out.println(cust);


//Room rm = new Room("356",123.80,RoomType.SINGLE);
//        FreeRoom fr = new FreeRoom("123",0.0,RoomType.DOUBLE);
//
//FreeRoom fr = new FreeRoom("4984",123.3,RoomType.DOUBLE);
//        Customer cus = new Customer("pope","triti","email");
//
//
//        //forma a date
//        String pattern = "dd/MM/yyyy";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        String date1 = "24/07/2021";
//        String date2 = "26/07/2021";
//        Date dateCheckIn = null;
//        Date dateCheckOut = null;
//        try {
//            dateCheckIn = simpleDateFormat.parse(date1);
//            dateCheckOut = simpleDateFormat.parse(date2);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//
//
//        //Check dates and how to parse to objects
//        Reservation reservation = new Reservation(cus,fr, dateCheckIn,dateCheckOut);
//        System.out.println(reservation);

    }
}
