package live.zeballos.reserva.controller;

import live.zeballos.reserva.model.Recurso;
import live.zeballos.reserva.service.IRecursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recurso")
public class RecursoController {

    private final IRecursoService recursoService;

    public RecursoController(IRecursoService recursoService) {
        this.recursoService = recursoService;
    }

    @GetMapping
    public List<Recurso> get() {
        return recursoService.getAll();
    }

    @GetMapping("/{id}")
    public Recurso get(@PathVariable Long id) {
        return recursoService.get(id);
    }

    @PostMapping
    public ResponseEntity<Recurso> create(@RequestBody Recurso recurso) {
        return ResponseEntity.ok(recursoService.create(recurso));
    }

    @PutMapping
    public ResponseEntity<Recurso> update(@RequestBody Recurso recurso) {
        return ResponseEntity.ok(recursoService.update(recurso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recurso> update(@RequestBody Recurso recurso, @PathVariable Long id) {
        return ResponseEntity.ok(recursoService.update(id, recurso));
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody Recurso recurso) {
        recursoService.delete(recurso);
        return ResponseEntity.ok("Se ha eliminado el recurso con id: " + recurso.getId());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        recursoService.delete(id);
        return ResponseEntity.ok("Se ha eliminado el recurso con id: " + id);
    }

}
