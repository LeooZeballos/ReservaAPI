package live.zeballos.reserva;

import org.springframework.stereotype.Service;

@Service
public class HolaMundoService {
    public String hola(String nombre) {
        return "{\"nombre\": \"Hola " + nombre + "\"}";
    }

    public String hello(String name) {
        return "{\"name\": \"Hello " + name + "\"}";
    }
}