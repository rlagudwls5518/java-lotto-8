package lotto.model.util;

public enum LottoConstants {

    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_SIZE(6),
    BONUS_LOTTO_SIZE(1);

    private final int number;

    LottoConstants(int number) {
        this.number = number;
    }

    public int getNumber(){
        return number;
    }
}
