package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;

import java.util.Collection;
import java.util.Date;


public class HotelResource {

    public static Customer getCustomer(String email){

       return CustomerService.getCustomer(email);

    }

    public static void createACustomer(String email, String firstName,String lastName){

        CustomerService.addCustomer(email,firstName,lastName);

    }

    public static IRoom getRoom(String roomNumber){

        return null;
    }

    public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){

        return null;
    }

    public static Collection<Reservation> getCustomerReservation(String customerEmail){

        return null;
    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut){

        return null;
    }


}
