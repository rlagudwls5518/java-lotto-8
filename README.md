# java-lotto-precourse
## 로또 과제에서의 기능 객체 목록

1. `Lotto` : 사용자가 입력한 당첨 로또 한장을 검증하고 저장하는 역할
2. `PurchaseInfo` : 사용자로부터 입력을 받은 구입금액에서 로또를 몇 개를 살 수있는지 알려주는 역할
3. `RandomNumbers` : 1-45까지 6개의 숫자를 랜덤으로 뽑아서 로또 한장 리스트로 반환해주는 역할
4. `LottoGenerator` : RandomNumbers에서 랜덤 로또 번호를  PerchancePrice에서의 갯수만큼 로또 장 수를 만들어주는 역할
5. `Calculator` : 랜덤 로또 번호와 당첨 로또번호, 보너스 번호를 비교해 번호 몇개가 맞았는지 계산하는 역할
6. `ResultRank` : `resultCalculator` 에 따라 등수랑 금액을 결정하는 역할
7. `ProfitCalculator` : 당첨 여부에 따라 수익률을 계산하는 역할
8. `InputView` : 모든 입력을 담당하는 역할
9. `OutputView` : 모든 출력을 담당하는 역할

## 객체 간 협력 흐름

1. **InputView** → 구입 금액, 당첨 번호, 보너스 번호 입력받음
2. **Controller** → 입력 전달(예외발생시 재입력 로직 추가)
3. **PurchaseInfo** → 구입 금액 기반 구매 수 계산
4. **LottoGenerator** → `RandomNumberGenerator` 이용해 로또 N장 생성
5. **Calculator** → 각 로또와 `WinningLotto` , `bonusNumber`비교
6. **ResultRank** → 맞은 개수로 등수 결정
7. **ProfitCalculator** → 총 수익률 계산
8. **OutputView** → 당첨 내역, 수익률 출력

## 예외처리 목록

- [x] 당첨 번호입력이 1~45범위가 아닐 경우
- [x] 보너스 번호 입력이 1~45범위가 아닐 경우
- [x] 보너스 번호 입력이 여러 개 일때
- [x] 보너스 번호와 당첨 번호가 같을 경우
- [x] 같은 번호가 2개 이상 있는 경우(중복제거)
- [x] 숫자가 아닌 입력 받을 경우
  - [x] 보너스 번호 입력일때
  - [x] 당첨 번호 입력일때
  - [x] 구매 금액 입력일때

## 테스트 케이스 목록

-[x] 구매금액 입력할때 천원단위 입력이 아닌 경우( 3400, 5780, 5555...)