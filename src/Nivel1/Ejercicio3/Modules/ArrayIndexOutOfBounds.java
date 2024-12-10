package Nivel1.Ejercicio3.Modules;

public class ArrayIndexOutOfBounds {
    public static void main(String[] args) {
       try{ throwException();}
       catch(ArrayIndexOutOfBoundsException e){
           System.out.println(e.getMessage());
       }
    }
    public static void throwException(){
      int[] array= new int [5];
      if (array.length>0||array.length<6){
          throw new ArrayIndexOutOfBoundsException("out of bounds");
      }else{
          System.out.println(array.toString());
      }
    }
}
