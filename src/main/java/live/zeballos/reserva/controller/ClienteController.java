package live.zeballos.reserva.controller;

import live.zeballos.reserva.model.Cliente;
import live.zeballos.reserva.service.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cliente")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ClienteController {

    private final IClienteService clienteService;

    @GetMapping
    public Page<Cliente> getAll(
            Pageable page,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String apellido,
            @RequestParam(required = false) String nroTelefono,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Integer dni,
            @RequestParam(required = false) String rolId
    ) {
        return clienteService.getAll(page, nombre, apellido, nroTelefono, email, dni, rolId);
    }

    @GetMapping("/{id}")
    public Cliente get(@PathVariable Long id) {
        return clienteService.get(id);
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.create(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.update(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.ok("Cliente eliminado");
    }

}
