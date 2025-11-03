package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashMap;
import java.util.Map;
import lotto.model.ProfitCalculator;
import lotto.model.ResultRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProfitCalculatorTest {


    @Test
    @DisplayName("총 당첨 금액과 구매 금액을 기준으로 수익률을 정확히 계산한다")
    void CalculateCorrectProfitRate() {
        // given
        int purchaseAmount = 8000;
        Map<ResultRank, Integer> resultCount = new HashMap<>();

        // when
        resultCount.put(ResultRank.FIFTH,1);// 5등 1개
        resultCount.put(null,7); // 꽝 7개
        ProfitCalculator profitCalculator = new ProfitCalculator(purchaseAmount, resultCount);
        // 수익률 = (총 상금 / 구매금액) * 100
        double expectedRate = 62.5;
        double actualRate = profitCalculator.calculateProfitRate();

        //then
        assertThat(expectedRate).isEqualTo(actualRate);
    }

    @Test
    @DisplayName("당첨이 없으면 수익률은 0%이다")
    void ReturnZeroProfitRateWhenNoWinning() {
        // given
        int purchaseAmount = 8000;
        Map<ResultRank, Integer> resultCount = new HashMap<>();
        resultCount.put(null,8);

        // when
        ProfitCalculator profitCalculator = new ProfitCalculator(purchaseAmount, resultCount);
        double actualRate = profitCalculator.calculateProfitRate();

        // then
        assertThat(actualRate).isZero();
    }
}
