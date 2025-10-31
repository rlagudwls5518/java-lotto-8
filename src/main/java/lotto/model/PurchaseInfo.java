package lotto.model;

public class PurchaseInfo {
    private final int price;

    public PurchaseInfo(int price) {
        this.price = price;
    }

    public int perchanceCount() {
        return price / 1000;
    }
}
