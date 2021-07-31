package ui;

import api.AdminResource;
import api.HotelResource;
import model.Customer;
import model.Reservation;

import java.util.Collection;
import java.util.Scanner;
import java.util.regex.Pattern;

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
                            seeMyReservation();
                            drawMainOptions();

                            t = false;
                        }
                        case 3 -> {

                            createAnAccount();
                            drawMainOptions();


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

public static void findAndReserveARoom(){

}

public static void seeMyReservation() {
    Scanner input = new Scanner(System.in);
    String email = null;
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

try {

        for (Reservation reservation : HotelResource.getCustomerReservation(email)) {

            System.out.println(reservation);

        }
    }catch (NullPointerException ex){

        System.out.println("No reservations found with the email provided.");

        }

    }

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

}








