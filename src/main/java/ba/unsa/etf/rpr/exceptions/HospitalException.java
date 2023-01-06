package ba.unsa.etf.rpr.exceptions;

public class HospitalException extends Exception{
    public HospitalException(String msg){
        super(msg);
    }
    public HospitalException(String msg, Exception reason){
        super(msg, reason);
    }
}
