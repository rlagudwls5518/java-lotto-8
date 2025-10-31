package lotto.model;

public record PurchaseInfo(int price) {

    public int perchanceCount() {
        return price / 1000;
    }
}
