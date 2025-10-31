package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {
    private final List<Lotto> Lottos;
    private final List<Integer> winNumbers;
    private final int bonusNumber;
    private final Map<ResultRank, Integer> resultCount = new HashMap<>();

    public Calculator(List<Lotto> Lottos, List<Integer> winNumbers, int bonusNumber) {
        this.Lottos = Lottos;
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<ResultRank, Integer> calculateWinningResult(){

        for (Lotto randomLotto : Lottos) {
            List<Integer> numbers = randomLotto.getNumbers();

            int matchCount = Math.toIntExact(numbers.stream()
                    .filter(winNumbers::contains)
                    .count());

            boolean bonusMatch = numbers.contains(bonusNumber);

            ResultRank rank = determineRank(matchCount, bonusMatch);

            resultCount.put(rank, resultCount.getOrDefault(rank, 0) + 1);
        }
        return resultCount;
    }

    private ResultRank determineRank(long matchCount, boolean bonusMatch) {
        if (matchCount == 6) return ResultRank.FIRST;
        if (matchCount == 5 && bonusMatch) return ResultRank.SECOND;
        if (matchCount == 5) return ResultRank.THIRD;
        if (matchCount == 4) return ResultRank.FOURTH;
        if (matchCount == 3) return ResultRank.FIFTH;
        return null;
    }


}
