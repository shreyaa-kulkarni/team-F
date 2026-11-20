// Team F - OutOfStokException.java
// custom exception 1: thrown when requested quantity is more than stock or stock is 0

public class OutOfStokException extends Exception {
    public OutOfStokException(String messge) {
        super(messge);
    }
}
