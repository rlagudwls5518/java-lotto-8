package lotto.model;

import java.util.Map;

public class ProfitCalculator {
    private static final int PURSENT_NUMBER = 100;
    private final int purchaseAmount;
    private final Map<ResultRank, Integer> resultCount;

    public ProfitCalculator(int purchaseAmount, Map<ResultRank, Integer> resultCount) {
        this.purchaseAmount = purchaseAmount;
        this.resultCount = resultCount;
    }

    public double calculateProfitRate() {
        long totalReward = 0;

        for (ResultRank rank : resultCount.keySet()) {
            int count = resultCount.get(rank);
            if (rank == null) {
                continue;
            }
            totalReward += (long) rank.getReward() * count;
        }

        return ((double) totalReward / purchaseAmount) * PURSENT_NUMBER;
    }
}
