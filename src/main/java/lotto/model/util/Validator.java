package lotto.model.util;

import lotto.model.Lotto;

public class Validator {
    public static final String NUMBER_REGEX = "^[0-9]+$";

    private Validator() {}

    public static void validateBonusDuplicateWithWinNumbers(int bonusNumber, Lotto winNumbers){
        if (winNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_BONUS_NUMBER);
        }
    }

    public static void validateIsNumber(String input) {
        if (!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_FORMAT);
        }
    }
}
