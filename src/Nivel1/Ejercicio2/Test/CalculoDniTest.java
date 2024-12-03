package Nivel1.Ejercicio2.Test;

import Nivel1.Ejercicio2.Modules.CalculoDni;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculoDniTest {

    @ParameterizedTest
    @CsvSource({
            "12345678, Z",
            "23456789, S",
            "34567890, Q",
            "45678901, V",
            "56789012, H",
            "67890123, L",
            "78901234, C",
            "89012345, K",
            "90123456, E",
            "12345679, R"
    })
    public void testCalcularLletra(int dniNumero, String lletraEsperada) {
        String lletraCalculada = CalculoDni.calcularLletra(dniNumero);
        Assertions.assertEquals(lletraEsperada, lletraCalculada);
    }

    @Test
    public void testDniIncorrecte() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CalculoDni.calcularLletra(100000000);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CalculoDni.calcularLletra(-1);
        });
    }
}
