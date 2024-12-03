package Nivel1.Ejercicio3.Modules;

public class ArrayIndexOutOfBounds {
    public static void throwException(){
      int[] array= new int [5];
      System.out.println(array[10]);
    }
}
