package Nivel1.Ejercicio3.Test;

import Nivel1.Ejercicio3.Modules.ArrayIndexOutOfBounds;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

    public class ArrayIndexOutOfBoundsTest {

        @Test
        public void testArrayIndexOutOfBoundsException() {

            assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                ArrayIndexOutOfBounds.throwException();
            });
        }
    }
