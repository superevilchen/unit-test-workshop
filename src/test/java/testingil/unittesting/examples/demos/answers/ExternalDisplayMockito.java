package testingil.unittesting.examples.demos.answers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import testingil.unittesting.examples.demos.d04.characterization.impl.CalcDisplayOther;
import testingil.unittesting.examples.demos.d04.characterization.impl.ExternalDisplay;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExternalDisplayMockito {

    @Mock
    ExternalDisplay externalDisplay;

    @InjectMocks
    CalcDisplayOther calcDisplayOther;

    @ParameterizedTest
    @MethodSource("cases")
    void getDisplay(List<String> params, String result) {

        when(externalDisplay.isOn()).thenReturn(true);

        params.forEach(calcDisplayOther::press);

        Assertions.assertEquals(result, calcDisplayOther.getDisplay());

    }

    static List<Arguments> cases(){
        return List.of(
                Arguments.of(List.of("0"), "0"),
                Arguments.of(List.of("1","+"), "1"),
                Arguments.of(List.of("10","/", "0"), "0"),
                Arguments.of(List.of("10","/", "0", "="), "E"),
                Arguments.of(List.of("C"), "C"),
                Arguments.of(List.of("1", "C"), "1C"),
                Arguments.of(List.of("-", "1", "+","-", "1"), "-1"),
//                Arguments.of(List.of("-", "1", "+","-", "1", "="), "?"),
                Arguments.of(List.of("0", "3", "4","5"), "0345"),
                Arguments.of(List.of("0", "0", "0","0"), "0000"),
//                Arguments.of(List.of("1", "3", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0")),
//                Arguments.of(List.of("1", "3", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "0","0", "+", "1")),
                Arguments.of(List.of("1", "+", "+"), "1"),
//                Arguments.of(List.of("1", "+", "+", "=")),
                Arguments.of(List.of("1+2*3="), "E")
        );
    }
}
