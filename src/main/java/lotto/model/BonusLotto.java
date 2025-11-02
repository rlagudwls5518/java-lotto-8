package lotto.model;

import lotto.model.util.ExceptionMessage;
import lotto.model.util.Validator;

public class BonusLotto {

    private final int bonusNumber;

    public BonusLotto(String bonusNumber){
        validBonusNumber(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public int getBonusNumber(){
        return bonusNumber;
    }

    public void validBonusNumber(String input){
        Validator.validateIsNumber(input);
        validateBonusNumberRange(input);
        validInputBonusNumberIsOne(input);
    }

    private void validInputBonusNumberIsOne(String inputBonusNumber){
        if(inputBonusNumber.length() != 1){
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_MUST_BE_ONE);
        }
    }
    private void validateBonusNumberRange(String inputBonusNumber){
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        if(bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_RANGE);
        }
    }
}
