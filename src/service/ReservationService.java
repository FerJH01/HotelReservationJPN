package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.awt.*;
import java.util.*;
import java.util.List;

public class ReservationService {

    private static ReservationService reservationService;
    private List<Reservation> reservations;
    private List<IRoom> allrooms;

    private ReservationService(){

        this.reservations = new ArrayList<Reservation>();
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

    public IRoom getARoom(String roomId){

        return null;
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){

        Reservation reservation = new Reservation(customer,room,checkInDate,checkOutDate);

        reservations.add(reservation);

        return null;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){

        return null;
    }

    public Collection<Reservation> getCustomersReservation(Customer customer){

        return null;
    }

    public void printAllReservation(){}

    public Collection<IRoom> getAllRooms(){

        return allrooms;
    }



}
