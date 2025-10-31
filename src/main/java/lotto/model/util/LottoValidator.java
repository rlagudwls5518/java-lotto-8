package lotto.model.util;

import lotto.model.Lotto;

public class LottoValidator {
    private static final String NUMBER_REGEX = "^[0-9]+$";

    public static void validInputPriceIsNumber(String inputPrice){
        if (!inputPrice.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_FORMAT);
        }
    }

    public static void validBonusNumber(String input, Lotto winNumbers){
        validateBonusNumberRange(input);
        validInputBonusNumberIsNumber(input);
        validInputBonusNumberIsOne(input);
        validateBonusDuplicateWithWinNumbers(input,winNumbers);
    }

    private static void validInputBonusNumberIsNumber(String inputBonusNumber){
        if (!inputBonusNumber.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_FORMAT);
        }
    }
    private static void validInputBonusNumberIsOne(String inputBonusNumber){
        if(inputBonusNumber.length() != 1){
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_MUST_BE_ONE);
        }
    }
    private static void validateBonusDuplicateWithWinNumbers(String inputBonusNumber, Lotto winNumbers){
        int bonusNumber = Integer.parseInt(inputBonusNumber);

        if (winNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_BONUS_NUMBER);
        }
    }
    private static void validateBonusNumberRange(String inputBonusNumber){
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        if(bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_RANGE);
        }
    }
}
