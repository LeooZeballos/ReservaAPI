package live.zeballos.reserva.controller;

import live.zeballos.reserva.model.Recurso;
import live.zeballos.reserva.service.IRecursoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/recurso")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RecursoController {

    private final IRecursoService recursoService;

    public RecursoController(IRecursoService recursoService) {
        this.recursoService = recursoService;
    }


    @GetMapping
    public Page<Recurso> get(
            Pageable page,
            @RequestParam(name = "nombre", required = false) String nombre,
            @RequestParam(name = "descripcion", required = false) String descripcion) {
        return recursoService.getAll(page, nombre, descripcion);
    }

    @GetMapping("/{id}")
    public Recurso get(@PathVariable Long id) {
        return recursoService.get(id);
    }

    @PostMapping
    public ResponseEntity<Recurso> create(@RequestBody Recurso recurso) {
        return ResponseEntity.ok(recursoService.create(recurso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recurso> update(@RequestBody Recurso recurso, @PathVariable Long id) {
        return ResponseEntity.ok(recursoService.update(id, recurso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        recursoService.delete(id);
        return ResponseEntity.ok("Se ha eliminado el recurso con id: " + id);
    }

}
