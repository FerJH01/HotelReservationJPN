package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;
import java.util.Collection;
import java.util.Date;


public class HotelResource {

    /**
     * Method returns a Customer object with a provided email address
     * @param email customer email address
     * @return Customer object
     */

    public static Customer getCustomer(String email){

       return CustomerService.getCustomerService().getCustomer(email);

    }

    /**
     * Method creates a customer object with provided parameters
     * @param email customer email address
     * @param firstName customer first name
     * @param lastName customer last name
     */

    public static void createACustomer(String email, String firstName,String lastName){

        CustomerService.getCustomerService().addCustomer(email,firstName,lastName);

    }

    /**
     * Method gets a room Object with the provided room number
     * @param roomNumber room number
     * @return Room Object
     */
    public static IRoom getRoom(String roomNumber){

        return ReservationService.getReservationService().getARoom(roomNumber);
    }

    /**
     * Method creares a reservation object with parameters provided
     * @param customerEmail customer email address
     * @param room room number
     * @param checkInDate check in date provided by user
     * @param checkOutDate check out date provided by user
     * @return null
     */
    public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){

        Customer customer = getCustomer(customerEmail);

        ReservationService.getReservationService().reserveARoom(customer,room,checkInDate,checkOutDate);

        return null;

    }

    /**
     * Method gets a reservation with the email provided
     * @param customerEmail customer email address
     * @return reservation object
     */
    public static Collection<Reservation> getCustomerReservation(String customerEmail){
        Collection<Reservation> customerReservations;
        Customer customer = getCustomer(customerEmail);

        customerReservations = ReservationService.getReservationService().getCustomersReservation(customer);

        return customerReservations;
    }

    /**
     * Method returns a Collection of rooms available within the date range
     * @param checkIn check in date provided by user
     * @param checkOut check out  date provided by user
     * @return Collection of rooms
     */
    public static Collection<IRoom> findARoom(Date checkIn, Date checkOut){


        return ReservationService.getReservationService().findRooms(checkIn, checkOut);
    }


}
