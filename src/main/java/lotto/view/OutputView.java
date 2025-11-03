package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.ResultRank;

public class OutputView {

    public static void printError(String message) {
        System.out.println(message);
    }

    public static void printPurchaseCount(int count){
        System.out.println(count+"개를 구매했습니다.");
    }

    public static void printRandomLotto(List<Lotto>numbers){
        for(Lotto number : numbers){
            System.out.println(number);
        }
    }
    public static void printInputPrice(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    public static void printInputWinLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    public static void printInputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printLottoResult(Map<ResultRank, Integer> resultCount){
        System.out.println("당첨통계");
        System.out.println("---");
        ResultRank[] ranks = ResultRank.values();
        for (int i = 0; i < ranks.length; i++) {
            ResultRank rank = ranks[i];
            if (rank == null) continue;

            int count = resultCount.getOrDefault(rank, 0);

            if (rank == ResultRank.SECOND) {
                System.out.printf("5개 일치, 보너스 볼 일치 (%s원) - %d개%n",
                        String.format("%,d", rank.getReward()), count);
                continue;
            }

            System.out.printf("%d개 일치 (%s원) - %d개%n",
                    rank.getMatchCount(),
                    String.format("%,d", rank.getReward()),
                    count);
        }
    }

    public static void printLottoProfitRate(double profitRate){
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
