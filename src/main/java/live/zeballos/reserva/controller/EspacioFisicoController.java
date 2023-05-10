package live.zeballos.reserva.controller;

import live.zeballos.reserva.model.EspacioFisico;
import live.zeballos.reserva.service.IEspacioFisicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/espacio-fisico")
public class EspacioFisicoController {

    private final IEspacioFisicoService espacioFisicoService;

    public EspacioFisicoController(IEspacioFisicoService espacioFisicoService) {
        this.espacioFisicoService = espacioFisicoService;
    }

    @GetMapping
    public List<EspacioFisico> get() {
        return espacioFisicoService.getAll();
    }

    @GetMapping("{id}")
    public EspacioFisico get(@PathVariable Long id) {
        return espacioFisicoService.get(id);
    }

    @PostMapping
    public ResponseEntity<EspacioFisico> create(@RequestBody EspacioFisico espacioFisico) {
        return ResponseEntity.ok(espacioFisicoService.create(espacioFisico));
    }

    @PutMapping("{id}")
    public ResponseEntity<EspacioFisico> update(@RequestBody EspacioFisico espacioFisico, @PathVariable Long id) {
        return ResponseEntity.ok(espacioFisicoService.update(id, espacioFisico));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        espacioFisicoService.delete(id);
        return ResponseEntity.ok("Se ha eliminado el espacio fisico con id: " + id);
    }

}
