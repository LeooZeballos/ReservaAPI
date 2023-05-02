package live.zeballos.reserva.controller;

import live.zeballos.reserva.service.IHolaMundoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HolaMundoController {
    IHolaMundoService holaMundoService;

    @GetMapping(value = {"/esp", "/es"}, params = {"nombre"})
    public String hola(String nombre) {
        return holaMundoService.hola(nombre);
    }

    @GetMapping(value = {"/eng", "/en"}, params = {"name"})
    public String hello(String name) {
        return holaMundoService.hello(name);
    }

}
