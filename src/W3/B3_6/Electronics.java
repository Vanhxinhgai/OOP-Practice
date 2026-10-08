package W3.B3_6;

public class Electronics extends Product {
    private static final double VAT_RATE = 0.1;
    private double warrantyFee;
    public Electronics(String id, String name, double basePrice, double warrantyFee) {
        super(id, name, basePrice);
        this.warrantyFee = warrantyFee;
    }
    @Override
    public double getFinalPrice() {
        double price = super.getFinalPrice();
        return price + price * VAT_RATE + warrantyFee;
    }
    @Override
    public String getType() {
        return "Electronics";
    }
}
