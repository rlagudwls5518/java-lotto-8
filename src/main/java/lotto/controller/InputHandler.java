package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.model.BonusLotto;
import lotto.model.Lotto;
import lotto.model.util.CommonValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputHandler {
    private static final String seperator = ",";

    public int inputPriceUntilValid() {
        while (true) {
            try {
                OutputView.printInputPrice();
                String price = InputView.input();
                CommonValidator.validateIsNumber(price);
                return Integer.parseInt(price);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
                return inputPriceUntilValid();
            }
        }
    }

    public int inputBonusNumberUntilValid() {
        while (true) {
            try {
                OutputView.printInputBonusNumber();
                String inputBonusNumber = InputView.input();
                BonusLotto bonusLotto = new BonusLotto(inputBonusNumber);
                return bonusLotto.getBonusNumber();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
                return inputBonusNumberUntilValid();
            }
        }
    }

    public Lotto inputWinningNumbersUntilValid() {
        while (true) {
            try {
                OutputView.printInputWinLotto();
                String inputNumbers = InputView.input();
                return createLottoFromInput(inputNumbers);

            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
                return inputWinningNumbersUntilValid();
            }
        }
    }

    public Lotto createLottoFromInput(String inputNumbers) {
        String[] winLottos = inputNumbers.split(seperator);

        List<Integer> lottoNumbers = Arrays.stream(winLottos)
                .map(this::validateAndParse)
                .toList();

        return new Lotto(lottoNumbers);
    }

    private int validateAndParse(String numberStr) {
        String trimmedStr = numberStr.trim();
        CommonValidator.validateIsNumber(trimmedStr);
        return Integer.parseInt(trimmedStr);
    }
}
