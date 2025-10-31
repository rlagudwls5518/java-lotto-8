package lotto.controller;

import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.ResultRank;
import lotto.model.util.Lottovalidator;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService){
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run(){

        //구매금액입력
        outputView.printInputPrice();
        String inputPrice = inputView.input();
        Lottovalidator.validInputPriceIsNumber(inputPrice);
        int price = Integer.parseInt(inputPrice);

        //구매금액에서갯수계산
        int count = lottoService.calculateLottoCount(price);
        outputView.printPurchaseCount(count);

        //랜덤로또출력
        LottoGenerator lottoGenerator = lottoService.generateLotto(count);
        outputView.printRandomLotto(lottoGenerator.getNumbers());

        //당첨로또입력
        outputView.printInputWinLotto();
        String[] input = inputView.input().split(",");
        Lotto winNumbers = lottoService.winLotto(input);

        //보너스넘버입력
        outputView.printInputBonusNumber();
        String inputBonusNumber = inputView.input();
        Lottovalidator.validBonusNumber(inputBonusNumber,winNumbers);
        int bonusNumber = Integer.parseInt(inputBonusNumber);


        Map<ResultRank, Integer> calculateResult = lottoService.lottoCalculater(lottoGenerator,winNumbers,bonusNumber);
        double profitRate= lottoService.calculateProfitRate(calculateResult, price);

        //로또결과랑 수익률출력
        outputView.printLottoResult(calculateResult);
        outputView.printlottoProfitRate(profitRate);
    }
}
