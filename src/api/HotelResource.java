package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;


public class HotelResource {

    public static Customer getCustomer(String email){

       return CustomerService.getCustomerService().getCustomer(email);

    }

    public static void createACustomer(String email, String firstName,String lastName){

        CustomerService.getCustomerService().addCustomer(email,firstName,lastName);

    }

    public static IRoom getRoom(String roomNumber){

        return ReservationService.getReservationService().getARoom(roomNumber);
    }

    //FALTA
    public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){

        Customer customer = getCustomer(customerEmail);

        ReservationService.getReservationService().reserveARoom(customer,room,checkInDate,checkOutDate);

        return null;

    }

    public static Collection<Reservation> getCustomerReservation(String customerEmail){
        Collection<Reservation> customerReservations;
        Customer customer = getCustomer(customerEmail);

        customerReservations = ReservationService.getReservationService().getCustomersReservation(customer);

        return customerReservations;
    }


    public static Collection<IRoom> findARoom(Date checkIn, Date checkOut){


        return ReservationService.getReservationService().findRooms(checkIn, checkOut);
    }


}
