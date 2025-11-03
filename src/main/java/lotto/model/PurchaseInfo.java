package lotto.model;

public class PurchaseInfo {
    private final int price;
    private static final int ONE_LOTTO_PRICE = 1000;

    public PurchaseInfo(int price) {
        this.price = price;
    }

    public int perchanceCount() {
        return price / ONE_LOTTO_PRICE;
    }
}
