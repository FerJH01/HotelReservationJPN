package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.awt.*;
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
        IRoom foundRoom = null;

        for (IRoom room : allrooms) {

            if (room.getRoomNumber().equals(roomId)) {
                foundRoom = room;
            }
        }
        return foundRoom;
    }


    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){

        Reservation reservation = new Reservation(customer,room,checkInDate,checkOutDate);

        reservations.add(reservation);

        return reservation;
    }

    //FALTA REVISAR VER DE CAMBIAR
    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){

        Collection<IRoom> availRooms = new HashSet<IRoom>();

        if(!reservations.isEmpty()){

            for(Reservation res : reservations){
                for(IRoom room : allrooms){

                    if(room.getRoomNumber().equals(res.getRoom().getRoomNumber())
                            && (checkInDate.before(res.getCheckInDate())) && (checkOutDate.before(res.getCheckOutDate()))
                        ||(checkInDate.after(res.getCheckInDate())) && (checkOutDate.after(res.getCheckOutDate()))
                        || (!res.getRoom().getRoomNumber().contains(room.getRoomNumber()))){

                        availRooms.add(room);

                    } else if (room.getRoomNumber().equals(res.getRoom().getRoomNumber())){

                        availRooms.remove(room);
                    }



                }

            }

        } else {

            availRooms = allrooms;
        }

        return availRooms;
    }

    public Collection<Reservation> getCustomersReservation(Customer customer){

        Collection<Reservation> allReservationsFound = new ArrayList<>();

            for (Reservation res : reservations) {

                if (res.getCustomer().equals(customer)) {

                    allReservationsFound.add(res);


                }


            }
        

        return allReservationsFound;
    }


    public void printAllReservation(){

        if(!reservations.isEmpty()) {

            for (Reservation reservation : reservations) {

                System.out.println(reservation);
            }

        }else{

            System.out.println("There are not reservations to show at the moment");

        }
    }

    public Collection<IRoom> getAllRooms(){

        return allrooms;
    }



}
