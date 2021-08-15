package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import java.util.*;
import java.util.List;

public class ReservationService {

    private static ReservationService reservationService;
    private Set<Reservation> reservations;
    private List<IRoom> allrooms;

    /**
     * Implementation of Singleton
     */
    private ReservationService(){

        this.reservations = new HashSet<>();
        this.allrooms = new ArrayList<IRoom>();

    }

    public static ReservationService getReservationService(){

        if(reservationService == null){

            reservationService = new ReservationService();
        }

        return reservationService;
    }


    /**
     * Method adds a room type IRoom to a Collection
     * @param room room Object
     */
    public void addRoom(IRoom room){

        allrooms.add(room);
    }

    /**
     * Method returns a room from Collection
     * @param roomId room id
     * @return room
     */
    public IRoom getARoom(String roomId) {

        return getRoom(roomId);
    }

    /**
     * Method adds a reservation object to a reservation Collection
     * @param customer Customer Object
     * @param room room Object
     * @param checkInDate check in date provided by the user
     * @param checkOutDate check out date provided by the user
     * @return null
     */
    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){

        Reservation reservation = new Reservation(customer,room,checkInDate,checkOutDate);

        reservations.add(reservation);

        return null;
    }

    /**
     * Method finds available rooms between provided date range and returns a Collection of rooms
     * @param checkInDate check in date provided by the user or added 7 days if no rooms found
     * @param checkOutDate check out date provided by the user or added 7 days if no rooms found
     * @return availRooms
     */
    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {

        Collection<IRoom> availRooms = new HashSet<>();

        if(reservations.size()==0){
            availRooms = allrooms;
            return availRooms;
        } else {
            for(IRoom room : allrooms){
                for(Reservation res : reservations){
                    if((room.getRoomNumber().equals(res.getRoom().getRoomNumber()))
                            && ((checkInDate.before(res.getCheckInDate()) && checkOutDate.before(res.getCheckInDate()))
                        || (checkInDate.after(res.getCheckOutDate()) && checkOutDate.after(res.getCheckOutDate()))) || (!res.getRoom().getRoomNumber().contains(room.getRoomNumber()))){

                        availRooms.add(room);

                    } else if (room.getRoomNumber().equals(res.getRoom().getRoomNumber())){

                        availRooms.remove(room);
                    }
                }

            }

        }
        fixRoomsOutput(availRooms,checkInDate,checkOutDate);

        return availRooms;
    }

    /**
     * Method gets a reservations Collection for a specific customer object
     * @param customer Customer Object
     * @return allReservationsFound
     */
    public Collection<Reservation> getCustomersReservation(Customer customer){

        return getReservation(customer);
    }

    /**
     * Method prints reservation objects
     */
    public void printAllReservation(){

        printReservations();
    }

    /**
     * Method returns a Collection of all rooms
     * @return allrooms
     */
     public Collection<IRoom> getAllRooms(){

        return allrooms;
    }

    /**
     * Auxiliary method that receives a Customer object and returns reservations found for that Customer.
     * @param customer a Customer Object
     * @return allReservationsFound
     */
    Collection<Reservation> getReservation(Customer customer){

         Collection<Reservation> allReservationsFound = new ArrayList<>();

         for (Reservation res : reservations) {

             if (res.getCustomer().equals(customer)) {

                 allReservationsFound.add(res);
             }
         }
         return allReservationsFound;
     }

    /**
     * Auxiliary method that prints reservations from the Reservations Collection
     */
    private void printReservations(){

        if(!reservations.isEmpty()) {
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
             }
        }else{
            System.out.println("There are not reservations to show at the moment");
        }
    }

    /**
     * Auxiliary method that gets a room with the provided room id
     * @param roomId room id number
     * @return foundRoom room object
     */
    IRoom getRoom(String roomId){

        IRoom foundRoom = null;
        for (IRoom room : allrooms) {

            if (room.getRoomNumber().equals(roomId)) {
                foundRoom = room;
            }
        }
        return foundRoom;
    }

    /**
     * Auxiliary method that iterates the Collections reservations and allRooms to validate the addition of the room to the collection availableRooms
     * @param availableRooms collection with available rooms in the given date
     * @param checkInDate check in date provided by the user
     * @param checkOutDate check out date provided by the user
     */
    private void fixRoomsOutput(Collection<IRoom> availableRooms, Date checkInDate, Date checkOutDate) {
        for(Reservation res : reservations){
            for(IRoom room : allrooms){
                if(room.getRoomNumber().equals(res.getRoom().getRoomNumber())
                        && !((checkInDate.before(res.getCheckInDate()) && checkOutDate.before(res.getCheckInDate()))
                        || (checkInDate.after(res.getCheckOutDate()) && checkOutDate.after(res.getCheckOutDate()))))
                    availableRooms.remove(room);
            }
        }
    }

}
