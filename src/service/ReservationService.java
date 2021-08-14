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

    private ReservationService(){

        this.reservations = new HashSet<Reservation>();
        this.allrooms = new ArrayList<IRoom>();

    }

    public static ReservationService getReservationService(){

        if(reservationService == null){

            reservationService = new ReservationService();
        }

        return reservationService;
    }


    public void addRoom(IRoom room){

        allrooms.add(room);
    }

    public IRoom getARoom(String roomId) {

        return getRoom(roomId);
    }


    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){

        Reservation reservation = new Reservation(customer,room,checkInDate,checkOutDate);

        reservations.add(reservation);

        return reservation;
    }


    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {

        Collection<IRoom> availRooms = new HashSet<IRoom>();


//        if (!reservations.isEmpty()) {
//
//            for (Reservation res : reservations) {
//
//                for (IRoom room : allrooms) {
//
//                    if (res.getRoom().getRoomNumber().equals(room.getRoomNumber())) {
//
//                        if ((checkInDate.before(res.getCheckInDate()) && checkOutDate.before(res.getCheckOutDate()) || (checkInDate.after(res.getCheckInDate()) && checkOutDate.after(res.getCheckOutDate())) || !res.getRoom().getRoomNumber().contains(room.getRoomNumber()))) {
//
//                            availRooms.add(room);
//
//                        } else if(room.getRoomNumber().equals(res.getRoom().getRoomNumber())){
//
//                            availRooms.remove(room);
//                        }
//                    }
//                }
//            }
//
//        } else {
//
//            availRooms = allrooms;
//        }
//
//        return availRooms;
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
        System.out.println(availRooms);

        return availRooms;
    }


    public Collection<Reservation> getCustomersReservation(Customer customer){

        return getReservation(customer);
    }


    public void printAllReservation(){

        printReservations();
    }

     public Collection<IRoom> getAllRooms(){


        return allrooms;
    }


    Collection<Reservation> getReservation(Customer customer){

         Collection<Reservation> allReservationsFound = new ArrayList<>();

         for (Reservation res : reservations) {

             if (res.getCustomer().equals(customer)) {

                 allReservationsFound.add(res);
             }
         }
         return allReservationsFound;
     }

     private void printReservations(){

        if(!reservations.isEmpty()) {
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
             }
        }else{
            System.out.println("There are not reservations to show at the moment");
        }
    }

    IRoom getRoom(String roomId){

        IRoom foundRoom = null;
        for (IRoom room : allrooms) {

            if (room.getRoomNumber().equals(roomId)) {
                foundRoom = room;
            }
        }
        return foundRoom;
    }

}
