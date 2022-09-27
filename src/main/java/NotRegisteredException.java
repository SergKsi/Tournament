public class NotRegisteredException extends RuntimeException {
    // родитель - RuntimeException
    public NotRegisteredException(String msg) {
        super(msg); // передаем сообщение RuntimeException
    }
}
