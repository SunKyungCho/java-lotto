package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResultMatcher {

    private final static String STRING_ENTER = "\n";
    private List<PickNumbers> lottoNumbers;

    public LottoResultMatcher(List<PickNumbers> lottos) {
        lottoNumbers = lottos;
    }

    public LottoAggregator matching(WinningNumbers winnerNumbers) {
        LottoAggregator lottoAggregator = new LottoAggregator();
        for (PickNumbers pickNumbers : lottoNumbers) {
            lottoAggregator.put(winnerNumbers.match(pickNumbers));
        }
        return lottoAggregator;
    }

    public List<PickNumbers> getLottos() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        List<String> lottos = lottoNumbers.stream()
                .map(pickNumbers -> pickNumbers.toString())
                .collect(Collectors.toList());
        return String.join(STRING_ENTER, lottos);
    }
}