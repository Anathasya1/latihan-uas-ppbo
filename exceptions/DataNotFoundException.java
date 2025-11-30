package exceptions;

public class DataNotFoundException extends Exception{
    public DataNotFoundException(String idInput){
        super("Data id " + idInput + " is not found");
    }
}
