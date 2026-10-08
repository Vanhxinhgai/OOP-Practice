package W3.B3_7;

public class StandardRoom extends Room {
    private static final long PRICE = 500_000;
    private static final int DISCOUNT_NIGHTS = 3;
    private static final int DISCOUNT_PERCENT = 5;
    @Override
    public long getPricePerNight() {
        return PRICE;
    }
    @Override
    public long calculateCost(int nights) {
        long total = super.calculateCost(nights);
        if (nights > DISCOUNT_NIGHTS) {
            total = total * (100 - DISCOUNT_PERCENT) / 100;
        }
        return total;
    }
    @Override
    public String getType() {
        return "Standard";
    }
}
