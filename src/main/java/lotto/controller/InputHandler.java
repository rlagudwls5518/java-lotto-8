package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.model.BonusLotto;
import lotto.model.Lotto;
import lotto.model.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputHandler {

    public int inputPriceUntilValid() {
        while (true) {
            try {
                OutputView.printInputPrice();
                String price = InputView.input();
                Validator.validateIsNumber(price);
                return Integer.parseInt(price);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
                return inputPriceUntilValid();
            }
        }
    }

    public int inputBonusNumber() {
        while (true){
            try{
                OutputView.printInputBonusNumber();
                String inputBonusNumber = InputView.input();
                BonusLotto bonusLotto = new BonusLotto(inputBonusNumber);
                return bonusLotto.getBonusNumber();
            } catch (IllegalArgumentException e){
                OutputView.printError(e.getMessage());
                return inputBonusNumber();
            }
        }
    }

    public Lotto inputWinningNumbersUntilValid() {
        while (true) {
            try {
                OutputView.printInputWinLotto();
                String inputNumbers = InputView.input();
                String[] winLottos = inputNumbers.split(",");
                List<Integer> lottoNumbers = Arrays.stream(winLottos)
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .toList();
                return new Lotto(lottoNumbers);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
                return inputWinningNumbersUntilValid();
            }
        }
    }
}
