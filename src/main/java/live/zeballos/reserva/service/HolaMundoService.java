package live.zeballos.reserva.service;

import org.springframework.stereotype.Service;

@Service
public class HolaMundoService implements IHolaMundoService {
    public String hola(String nombre) {
        return "{\"nombre\": \"Hola " + nombre + "\"}";
    }

    public String hello(String name) {
        return "{\"name\": \"Hello " + name + "\"}";
    }
}
