package live.zeballos.reserva;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {
    @GetMapping(value = {"/esp", "/es"}, params = {"nombre"})
    public String hola(String nombre) {
        return "{\"nombre\": \"Hola " + nombre + "\"}";
    }

    @GetMapping(value = {"/eng/{name}", "/en/{name}"})
    public String hello(@PathVariable String name) {
        return "{\"name\": \"Hello " + name + "\"}";
    }

}
