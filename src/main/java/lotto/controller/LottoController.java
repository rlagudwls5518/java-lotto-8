package lotto.controller;

import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.ResultRank;
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
        int price = Integer.parseInt(inputView.input());

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
        int bonusNumber = Integer.parseInt(inputView.input());


        Map<ResultRank, Integer> calculateResult = lottoService.lottoCalculater(lottoGenerator,winNumbers,bonusNumber);
        double profitRate= lottoService.calculateProfitRate(calculateResult, price);

        //로또결과랑 수익률출력
        outputView.printLottoResult(calculateResult);
        outputView.printlottoProfitRate(profitRate);
    }
}
