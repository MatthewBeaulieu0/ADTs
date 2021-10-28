package QueueExceptions;

public class AbsentKeyException extends Exception{
    public AbsentKeyException(){
        super();
    }
    public AbsentKeyException(String message){
        super(message);
    }
}
