package W3.B3_7;

public abstract class Room {
    public abstract long getPricePerNight();
    public abstract String getType();
    public long calculateCost(int nights) {
        return getPricePerNight() * nights;
    }
    public boolean hasFreeBreakfast() {
        return false;
    }
}
