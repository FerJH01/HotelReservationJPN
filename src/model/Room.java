package model;

import java.util.Objects;

public class Room implements IRoom{


    private String roomNumber;
    private Double price;
    private RoomType enumeration;

    public Room(String roomNumber, Double price, RoomType enumeration) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setEnumeration(RoomType enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return price;
    }

    @Override
    public RoomType getRoomType() {
        return enumeration;
    }

    @Override
    public boolean isFree() {
        return false;
    }


    @Override
    public String toString() {
        return "***********************************" + "\n"
                + "Room number: " + roomNumber + "\n" +
                "Room type: " + enumeration + "\n" +
                "Room price: " + price + "\n"
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return getRoomNumber().equals(room.getRoomNumber()) && price.equals(room.price) && enumeration == room.enumeration;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoomNumber(), price, enumeration);
    }
}
