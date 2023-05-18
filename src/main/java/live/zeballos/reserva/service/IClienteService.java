package live.zeballos.reserva.service;

import live.zeballos.reserva.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IClienteService extends IService<Cliente> {
    Page<Cliente> getAll(Pageable page, String nombre, String apellido, String nroTelefono, String email, Integer dni, String rolId);
}
