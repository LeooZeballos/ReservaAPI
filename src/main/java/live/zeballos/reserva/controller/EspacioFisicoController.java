package live.zeballos.reserva.controller;

import live.zeballos.reserva.model.EspacioFisico;
import live.zeballos.reserva.service.IEspacioFisicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping(params = {"page"})
    public Page<EspacioFisico> get(Pageable page) {
        return espacioFisicoService.getAll(page);
    }

    @GetMapping("{id}")
    public EspacioFisico get(@PathVariable Long id) {
        return espacioFisicoService.get(id);
    }

    @GetMapping(params = {"nombre"})
    public List<EspacioFisico> getByNombre(@RequestParam String nombre) {
        return espacioFisicoService.getByNombre(nombre);
    }

    @GetMapping(params = {"capacidad"})
    public List<EspacioFisico> getByNombre(@RequestParam int capacidad) {
        return espacioFisicoService.getByCapacidad(capacidad);
    }

    @GetMapping(params = {"nombre", "capacidad"})
    public List<EspacioFisico> getByNombre(@RequestParam String nombre, @RequestParam int capacidad) {
        return espacioFisicoService.getByNombreAndCapacidad(nombre, capacidad);
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
