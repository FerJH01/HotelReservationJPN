package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {

    public static Customer getCustomer(String email){

        return CustomerService.getCustomerService().getCustomer(email);
    }

    public static void addRoom(List<IRoom> rooms){

        for(IRoom room : rooms){
            ReservationService.getReservationService().addRoom(room);
        }

    }

    public static Collection<IRoom> getAllRooms() {


        return ReservationService.getReservationService().getAllRooms();
    }

    public static Collection<Customer> getAllCustomer(){


        return CustomerService.getCustomerService().getAllCustomers();
    }

    public static void displayAllReservations(){}


}
