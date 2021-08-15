package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;
import java.util.Collection;
import java.util.List;

public class AdminResource {

    /**
     * Methods gets a Customer Object with a provided email address
     * @param email customer email address
     * @return Customer Object
     */
    public static Customer getCustomer(String email){

        return CustomerService.getCustomerService().getCustomer(email);
    }

    /**
     * Method adds a room Object to a IRoom Collection
     * @param rooms Collection of room Objects
     */
    public static void addRoom(List<IRoom> rooms){

        for(IRoom room : rooms){
            ReservationService.getReservationService().addRoom(room);
        }

    }

    /**
     * Method gets a Collection of all rooms
     * @return rooms
     */
    public static Collection<IRoom> getAllRooms() {


        return ReservationService.getReservationService().getAllRooms();
    }

    /**
     * Method gets a Collection of all Customers
     * @return Customers
     */
    public static Collection<Customer> getAllCustomer(){


        return CustomerService.getCustomerService().getAllCustomers();
    }

    /**
     * Method prints all reservations in the Reservation Collection
     */
    public static void displayAllReservations(){

        ReservationService.getReservationService().printAllReservation();
    }


}
