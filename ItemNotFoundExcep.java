// Team F - ItemNotFoundExcep.java
// custom exception 2: thrown when user inputs item id that does not exist

public class ItemNotFoundExcep extends Exception {
    public ItemNotFoundExcep(String messge) {
        super(messge);
    }
}
