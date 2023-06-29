package live.zeballos.reserva.controller;

import live.zeballos.reserva.model.EspacioFisico;
import live.zeballos.reserva.service.IEspacioFisicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/espacio-fisico")
@RequiredArgsConstructor
public class EspacioFisicoController {

    private final IEspacioFisicoService espacioFisicoService;

    @GetMapping
    public Page<EspacioFisico> getByNombre(
            Pageable page,
            @RequestParam(name = "nombre", required = false) String nombre,
            @RequestParam(name = "capacidad", required = false) Integer capacidad,
            @RequestParam(name = "descripcion", required = false) String descripcion,
            @RequestParam(name = "habilitado", required = false) Boolean habilitado
    ) {
        return espacioFisicoService.getAll(page, nombre, capacidad, descripcion, habilitado);
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
