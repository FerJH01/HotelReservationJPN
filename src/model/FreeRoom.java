package model;

public class FreeRoom extends Room{

    public FreeRoom(String roomNumber, Double price, RoomType enumeration) {
        super(roomNumber, 0.00, enumeration);
    }


    @Override
    public boolean isFree() {
        return true;
    }

    @Override
    public String toString() {
        return "FreeRoom{" +
                "roomNumber='" + super.getRoomNumber()+ '\'' +
                ", price=" + isFree() +
                ", RoomType=" + super.getRoomType() +
                '}';
    }
}
