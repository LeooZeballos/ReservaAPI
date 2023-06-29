package live.zeballos.reserva.error;

public class ReservaAlreadyExistsException extends RuntimeException {
    public ReservaAlreadyExistsException(String message) {
        super(message);
    }
}
