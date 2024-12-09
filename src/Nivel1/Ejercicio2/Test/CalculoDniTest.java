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
            "78901234, X",
            "45678901, G",
            "34567890, V",
            "89012345, E",
            "67890123, B"
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
