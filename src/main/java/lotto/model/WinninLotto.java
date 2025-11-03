package lotto.model;

import lotto.model.util.ExceptionMessage;

public class WinninLotto {
    private final int bonusNumber;
    private final Lotto winLottos;

    public WinninLotto(int bonusNumber, Lotto winLottos) {
        validateBonusDuplicateWithWinNumbers(bonusNumber, winLottos);
        this.bonusNumber = bonusNumber;
        this.winLottos = winLottos;
    }

    private static void validateBonusDuplicateWithWinNumbers(int bonusNumber, Lotto winNumbers) {
        if (winNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_BONUS_NUMBER);
        }
    }

    public Lotto getWinLottos() {
        return winLottos;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
