package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.ResultRank;

public class OutputView {

    public static void printError(String message) {
        System.out.println(message);
    }

    public static void printPurchaseCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printRandomLotto(List<Lotto> numbers) {
        for (Lotto number : numbers) {
            System.out.println(number);
        }
    }

    public static void printInputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printInputWinLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printLottoResult(Map<ResultRank, Integer> resultCount) {
        printResultHeader();
        ResultRank[] ranks = ResultRank.values();
        for (ResultRank rank : ranks) {
            if (rank == null) {
                continue;
            }

            int count = resultCount.getOrDefault(rank, 0);
            String message = printRankFormat(rank, count);
            System.out.println(message);
        }
    }

    private static void printResultHeader() {
        System.out.println("당첨통계");
        System.out.println("---");
    }

    private static String printRankFormat(ResultRank rank, int count) {
        String formattedReward = formatMoney(rank.getReward());
        if (rank == ResultRank.SECOND) {
            System.out.printf("5개 일치, 보너스 볼 일치 (%s원) - %d개%n",
                    String.format("%,d", rank.getReward()), count);
        }
        return String.format("%d개 일치 (%s원) - %d개",
                rank.getMatchCount(),
                formattedReward, count);
    }

    private static String formatMoney(int amount) {
        return String.format("%,d", amount);
    }

    public static void printLottoProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
