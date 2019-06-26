package lotto.model;

import java.util.List;

public class WinningNumbers extends LottoNumbers {


    private List<Integer> numbers;
    private Integer bonusNumber;

    public WinningNumbers(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
        verifyNumber(bonusNumber);
        verifyBonusDuplication(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank match(PickNumbers pickNumbers) {
        long matchCount = this.numbers.stream()
                .filter(pickNumbers::contains)
                .count();

        return LottoRank.match((int) matchCount, hasBonus(pickNumbers));
    }

    private boolean hasBonus(PickNumbers pickNumbers) {
        return pickNumbers.contains(bonusNumber);
    }

    private void verifyBonusDuplication(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("이미 번호가 뽑혀있습니다. ");
        }
    }
}
