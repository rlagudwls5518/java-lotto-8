# java-lotto-precourse
## 로또 과제에서의 객체들

1. `Lotto` : 사용자가 입력한 당첨 로또 한장을 검증하고 저장하는 역할
2. `PurchaseInfo` : 사용자로부터 입력을 받은 구입금액에서 로또를 몇 개를 살 수있는지 알려주는 역할
3. `RandomNumbers` : 1-45까지 6개의 숫자를 랜덤으로 뽑아서 로또 한장 리스트로 반환해주는 역할
4. `LottoGenerator` : RandomNumbers에서 랜덤 로또 번호를   PerchancePrice에서의 갯수만큼 로또 장 수를 만들어주는 역할
5. `ResultCalculator` : 랜덤 로또 번호와 당첨 로또번호, 보너스 번호를 비교해 번호 몇개가 맞았는지 계산하는 역할
6. `ResultRank` : `resultCalculator` 에 따라 등수랑 금액을 결정하는 역할
7. `ProfitCalculator` : 당첨 여부에 따라 수익률을 계산하는 역할
8. `InputView` : 모든 입력을 담당하는 역할
9. `OutputView` : 모든 출력을 담당하는 역할
10. `Controller` : Application으로 가기전에 로또과제 흐름을 정리하는 역할

## 객체 간 협력 흐름

1. **InputView** → 구입 금액, 당첨 번호, 보너스 번호 입력받음
2. **Controller** → 입력 전달
3. **PurchaseInfo** → 구입 금액 기반 구매 수 계산
4. **LottoGenerator** → `RandomNumberGenerator` 이용해 로또 N장 생성
5. **ResultCalculator** → 각 로또와 `WinningLotto` , `bonusNumber`비교
6. **ResultRank** → 맞은 개수로 등수 결정
7. **ProfitCalculator** → 총 수익률 계산
8. **OutputView** → 당첨 내역, 수익률 출력

## 예외처리 목록

- 입력이 1000원 단위가 아닐경우
- 당첨 번호입력이 1~45범위가 아닐 경우
- 보너스 번호 입력이 1~45범위가 아닐 경우
- 같은 번호가 2개 이상 있는경우
- 숫자가 아니라 문자를 입력 받을경우