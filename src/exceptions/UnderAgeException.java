package exceptions;

public class UnderAgeException extends Exception{

    public UnderAgeException() {
        super("La persona que intenta ingresar es menor de edad");
    }//End constructor

}//End UnderAgeException class
