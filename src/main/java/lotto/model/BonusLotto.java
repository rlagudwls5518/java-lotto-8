package lotto.model;

import lotto.model.util.ExceptionMessage;
import lotto.model.util.CommonValidator;
import lotto.model.util.LottoConstants;

public class BonusLotto {

    private final int bonusNumber;

    public BonusLotto(String bonusNumber) {
        validBonusNumber(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void validBonusNumber(String input) {
        CommonValidator.validateIsNumber(input);
        validateBonusNumberRange(input);
        validInputBonusNumberIsOne(input);
    }

    private void validInputBonusNumberIsOne(String inputBonusNumber) {
        if (inputBonusNumber.length() != LottoConstants.BONUS_LOTTO_SIZE.getNumber()) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_MUST_BE_ONE);
        }
    }

    private void validateBonusNumberRange(String inputBonusNumber) {
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        if (bonusNumber < LottoConstants.MIN_LOTTO_NUMBER.getNumber()
                || bonusNumber > LottoConstants.MAX_LOTTO_NUMBER.getNumber()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_RANGE);
        }
    }
}
