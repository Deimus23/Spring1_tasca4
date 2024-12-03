package Nivel1.Ejercicio2.Modules;

public class CalculoDni {
    private static final String DniLetters = "TRWAGMYFPDXBNJZSQVHLCKE";

    public static String calcularLletra(int dniNumero) {

        if (dniNumero < 0 || dniNumero > 99999999) {
            throw new IllegalArgumentException("El número del DNI ha de ser entre 0 i 99999999.");
        }
        int index = dniNumero % 23;
        return String.valueOf(DniLetters.charAt(index));
    }
}
