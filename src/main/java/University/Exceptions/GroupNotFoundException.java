package University.Exceptions;

public class GroupNotFoundException extends RuntimeException{

    public GroupNotFoundException(String message) {
        super(message);
    }
}
