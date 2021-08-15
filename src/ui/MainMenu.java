package ui;

import api.AdminResource;
import api.HotelResource;
import model.Customer;
import model.IRoom;
import model.Reservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.*;
import java.util.regex.Pattern;

public class MainMenu {

    /**
     * Method that prints main options to the terminal
     */

    public static void drawMainOptions() {

        try (Scanner scanner = new Scanner(System.in)) {

            while (true) {

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
                        case 1 -> findAndReserveARoom();
                        case 2 -> seeMyReservation();
                        case 3 -> createAnAccount();
                        case 4 -> AdminMenu.drawAdminOptions();
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

    /**
     * Method that finds and reserves an available room within specified date ranges.
     * if no room is available, adds 7 days to check in and check out.
     */
    public static void findAndReserveARoom() {

        Scanner input = new Scanner(System.in);
        String email;
        String checkIn;
        String checkOut;
        Date dateCheckIn = null;
        Date dateCheckOut = null;
        String patter = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patter);
        LocalDate currentLocalDate = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date currentDate = Date.from(currentLocalDate.atStartOfDay(defaultZoneId).toInstant());
        Collection<IRoom> availableRooms;
        String roomChosen;
        boolean out = true;
        String seeFreeRoomsNextWeek;
        IRoom chosenRoomObject = null;
        boolean keepHere = true;
        email = emailValidator();

        if (HotelResource.getCustomer(email) != null) {


            boolean dateIsBeforeCurrent;
            boolean dateCheckOutbeforedateCheckIn;

        do {
            dateIsBeforeCurrent = false;

            System.out.println("Please enter check In Date in format dd/mm/yyyy: ");
            checkIn = input.nextLine();

            dateValidator(checkIn);

            try {

                dateCheckIn = simpleDateFormat.parse(checkIn);


            } catch (ParseException e) {

                System.out.println("Invalid date");

            }

            try {

                if (dateCheckIn != null) {
                    dateIsBeforeCurrent = dateCheckIn.before(currentDate);

                }

            } catch (NullPointerException ex) {
                System.out.println("Current Date is null");
            }

        } while ((!dateValidator(checkIn)) || dateIsBeforeCurrent);


        do {
            dateCheckOutbeforedateCheckIn = false;

            System.out.println("Please enter check Out Date dd/mm/yyyy: ");
            checkOut = input.nextLine();

            dateValidator(checkOut);

            try {
                dateCheckOut = simpleDateFormat.parse(checkOut);

            } catch (ParseException e) {

                System.out.println("Invalid date");
            }

            try {

                if (dateCheckOut != null) {
                    dateIsBeforeCurrent = dateCheckOut.before(currentDate);
                    dateCheckOutbeforedateCheckIn = dateCheckOut.before(dateCheckIn);

                }

            } catch (NullPointerException ex) {

                System.out.println("Current Date is null");

            }

        } while (!dateValidator(checkOut) || dateIsBeforeCurrent || dateCheckOutbeforedateCheckIn);

    } else {

        System.out.println("You need to create an account first. Please select option 3.");
        drawMainOptions();
    }


    do{
        availableRooms = HotelResource.findARoom(dateCheckIn, dateCheckOut);

        if (availableRooms.isEmpty()) {

            System.out.println("There are no rooms available at the moment" + "\n");

            do {
                System.out.println("Would you like to see rooms available in the next 7 days? y/n");
                seeFreeRoomsNextWeek = input.nextLine().toLowerCase().trim();
            } while (!seeFreeRoomsNextWeek.equals("y") && !seeFreeRoomsNextWeek.equals("n"));

            if (seeFreeRoomsNextWeek.equals("y")) {

                Calendar c1 = Calendar.getInstance();
                Calendar c2 = Calendar.getInstance();
                c1.setTime(dateCheckIn);
                c2.setTime(dateCheckOut);
                c1.add(Calendar.DATE, 7);
                c2.add(Calendar.DATE, 7);

                try {
                    dateCheckIn = simpleDateFormat.parse(simpleDateFormat.format(c1.getTime()));
                    dateCheckOut = simpleDateFormat.parse(simpleDateFormat.format(c2.getTime()));
                    System.out.println("Checkin Date: " + dateCheckIn);
                    System.out.println("Checkout Date: " + dateCheckOut);

                } catch (ParseException ex) {

                    System.out.println("Unable to parse the date");
                }

                availableRooms = HotelResource.findARoom(dateCheckIn, dateCheckOut);
                System.out.println("Available Rooms");

                for (IRoom room : availableRooms) {

                    System.out.println(room);
                }
            } else {

                keepHere = false;
                out = false;

            }
        } else {

            keepHere = false;
            
            System.out.println("Available Rooms");

            for (IRoom room : availableRooms) {

                System.out.println(room);

            }
        }
    }while(keepHere);



    while(out){
        System.out.println("Please choose the room number you would like to reserve: ");
        roomChosen = input.nextLine();


        if (HotelResource.getRoom(roomChosen) == null) {

            System.out.println("Invalid Room number.");

        } else {
            chosenRoomObject = HotelResource.getRoom(roomChosen);

            System.out.println("**You have reserved the following room**");

            System.out.println(HotelResource.getRoom(roomChosen));

            HotelResource.bookARoom(email, chosenRoomObject, dateCheckIn, dateCheckOut);

            out = false;
        }

    }


}

    /**
     * Method that prints all reservations for a specified customer email.
     */
    public static void seeMyReservation() {

        Collection <Reservation> myReservations;
        String email;
        email = emailValidator();

        try {
            myReservations = HotelResource.getCustomerReservation(email);

            if(!myReservations.isEmpty()) {

                for (Reservation reservation : myReservations) {

                System.out.println(reservation);
            }

            }else{

                System.out.println("No reservations found with the provided email.");
            }

    }catch (NullPointerException ex){

        System.out.println("No reservations found with the provided email.");

        }
}

    /**
     * Method that allows to create an account in the system
     */
    public static void createAnAccount(){

        String email;
        String firstName;
        String lastName;
        Customer cust = null;
        boolean t = true;

        System.out.println("CREATING AN ACCOUNT");
        System.out.println("------------------------");

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Please enter your First Name: ");
            firstName = scanner.nextLine();
        } while(firstName.isBlank());

        do {
            System.out.println("Please enter your Last Name: ");
            lastName = scanner.nextLine();
        } while(lastName.isBlank());

            while(t) {
                t = false;
                System.out.println("Please enter an email address in the format name@domain.domain: ");
                email = scanner.nextLine();

                while(HotelResource.getCustomer(email)!=null){

                    System.out.println("The email provided is already registered. Please provide a different email: ");
                    email = scanner.nextLine();
                }

                try {
                    HotelResource.createACustomer(email, firstName, lastName);
                    cust = AdminResource.getCustomer(email);
                } catch (IllegalArgumentException ex) {

                    System.out.println("ERROR! The email is in the wrong format"+"\n");
                    t = true;
                }


            }
                System.out.println("Account created successfully");

                System.out.println(cust);
    }

    /**
     * Method that validates the email provided is valid according format defined by Regex.
     * @return validated email
     */
    public static String emailValidator(){
        Scanner input = new Scanner(System.in);
        String email;

        final String emailRegex = "^(.+)@(.+).(.+)$";
        final Pattern pattern = Pattern.compile(emailRegex);
        boolean t = true;

        do{
            System.out.println("Please enter your email: ");
            email = input.nextLine();

            if (pattern.matcher(email).matches()) {

                t = false;

            } else {

                System.out.println("Enter a correct email address");
            }
        }while(t);

        return email;

    }

    /**
     * Method that validates the date provided by the user.
     * @param date provided by the user.
     * @return boolean
     */
    public static boolean dateValidator(String date){

        final DateTimeFormatter dateformat = new DateTimeFormatterBuilder()
                .parseStrict()
                .appendPattern("dd/MM/uuuu")
                .toFormatter()
                .withResolverStyle(ResolverStyle.STRICT);

        try {

            LocalDate.parse(date,dateformat);

        }catch(DateTimeParseException ex){


            return false;

        }

        return true;
    }


}








