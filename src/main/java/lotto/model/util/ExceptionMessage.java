package lotto.model.util;

public class ExceptionMessage {

    public static final String INVALID_LOTTO_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String INVALID_NUMBER_RANGE = "[ERROR] 번호는 1~45 사이여야 합니다.";
    public static final String DUPLICATED_BONUS_NUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    public static final String INVALID_NUMBER_FORMAT = "[ERROR] 숫자만 가능합니다";
    public static final String BONUS_NUMBER_MUST_BE_ONE = "[ERROR] 보너스 숫자는 1개만 가능합니다";
    public static final String DUPLICATED_LOTTO_NUMBERS = "[ERROR] 로또번호는 중복될 수 없습니다.";

    private ExceptionMessage() {
    }

}
