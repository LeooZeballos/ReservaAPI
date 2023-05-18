package live.zeballos.reserva.controller;

import live.zeballos.reserva.model.Rol;
import live.zeballos.reserva.service.IRolService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rol")
public class RolController {

    private final IRolService rolService;

    public RolController(IRolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public Page<Rol> getAll(
            Pageable page,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String descripcion
    ) {
        return rolService.getAll(page, nombre, descripcion);
    }

    @GetMapping("/{id}")
    public Rol get(@PathVariable Long id) {
        return rolService.get(id);
    }

    @PostMapping
    public ResponseEntity<Rol> create(@RequestBody Rol rol) {
        return ResponseEntity.ok(rolService.create(rol));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> update(@PathVariable Long id, @RequestBody Rol rol) {
        return ResponseEntity.ok(rolService.update(id, rol));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        rolService.delete(id);
        return ResponseEntity.ok("Rol con id " + id + " eliminado correctamente.");
    }

}
