package W3.B3_6;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Food extends Product {
    private LocalDate expiryDate;
    private LocalDate today;
    public Food(String id, String name, double basePrice,
                LocalDate expiryDate, LocalDate today) {
        super(id, name, basePrice);
        this.expiryDate = expiryDate;
        this.today = today;
    }
    @Override
    public double getFinalPrice() {
        long daysLeft = ChronoUnit.DAYS.between(today, expiryDate);
        if (daysLeft < 7) {
            return super.getFinalPrice() * 0.8;   // giảm 20%
        }
        return super.getFinalPrice();             // không chịu thuế
    }
    @Override
    public String getType() {
        return "Food";
    }
}
