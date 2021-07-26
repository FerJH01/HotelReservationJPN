import api.HotelResource;
import model.*;
import ui.MainMenu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Driver {


    public static void main(String[] args) {

        MainMenu.drawMainOptions();

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
