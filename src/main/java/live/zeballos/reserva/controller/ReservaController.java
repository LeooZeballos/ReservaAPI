package live.zeballos.reserva.controller;

import live.zeballos.reserva.model.Reserva;
import live.zeballos.reserva.service.IReservaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reserva")
public class ReservaController {

    private final IReservaService reservaService;

    public ReservaController(IReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public Page<Reserva> getAll(
            Pageable pageable,
            @RequestParam(required = false) Integer duracion,
            @RequestParam(required = false) String comentario,
            @RequestParam(required = false) String clienteId,
            @RequestParam(required = false) String motivoReserva,
            @RequestParam(required = false) String estadoId,
            @RequestParam(required = false) String motivoRechazo,
            @RequestParam(required = false) String espacioFisicoId
    ) {
        return reservaService.getAll(pageable, duracion, comentario, clienteId, motivoReserva, estadoId, motivoRechazo, espacioFisicoId);
    }

    @GetMapping("/{id}")
    public Reserva get(@PathVariable Long id) {
        return reservaService.get(id);
    }

    @PostMapping
    public ResponseEntity<Reserva> create(@RequestBody Reserva reserva) {
        return ResponseEntity.ok(reservaService.create(reserva));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> update(@PathVariable Long id, @RequestBody Reserva reserva) {
        return ResponseEntity.ok(reservaService.update(id, reserva));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        reservaService.delete(id);
        return ResponseEntity.ok("Reserva con id " + id + " eliminada correctamente.");
    }

}
