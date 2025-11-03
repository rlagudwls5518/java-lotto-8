package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoCalculator {
    private final List<Lotto> lottos;
    private final Lotto winNumbers;
    private final int bonusNumber;

    public LottoCalculator(List<Lotto> lottos, Lotto winNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<ResultRank, Integer> calculateWinningResult() {
        Map<ResultRank, Integer> resultCount = new EnumMap<>(ResultRank.class);
        List<Integer> winNumber = winNumbers.getNumbers();

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();

            boolean bonusMatch = numbers.contains(bonusNumber);

            ResultRank rank = ResultRank.valueOf(whatMatchCount(numbers,winNumber), bonusMatch);
            isMiss(rank, resultCount);
        }
        return resultCount;
    }

    private void isMiss(ResultRank rank, Map<ResultRank, Integer> resultCount){
        if (rank != null) {
            resultCount.put(rank, resultCount.getOrDefault(rank, 0) + 1);
        }
    }

    private long whatMatchCount(List<Integer> numbers, List<Integer> winNumber){
        return numbers.stream()
                .filter(winNumber::contains)
                .count();
    }
}
