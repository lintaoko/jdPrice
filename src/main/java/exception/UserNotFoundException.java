package exception;

public class UserNotFoundException extends RuntimeException {
    private int  userId;

    public UserNotFoundException(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }
}
