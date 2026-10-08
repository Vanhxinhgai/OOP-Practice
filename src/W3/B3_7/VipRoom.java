package W3.B3_7;

public class VipRoom extends Room {
    private static final long PRICE = 2_000_000;
    @Override
    public long getPricePerNight() {
        return PRICE;
    }
    @Override
    public boolean hasFreeBreakfast() {
        return true;
    }
    @Override
    public String getType() {
        return "VIP";
    }
}
