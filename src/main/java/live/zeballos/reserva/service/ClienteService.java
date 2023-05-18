package live.zeballos.reserva.service;

import live.zeballos.reserva.model.Cliente;
import live.zeballos.reserva.query.ClienteQueryParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import live.zeballos.reserva.repository.ClienteRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService implements IClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Page<Cliente> getAll(Pageable page) {
        return clienteRepository.findAll(page);
    }

    @Override
    public Page<Cliente> getAll(Pageable page, String nombre, String apellido, String nroTelefono, String email, Integer dni, String rolId) {
        return clienteRepository.findByParams(
                ClienteQueryParams.builder()
                        .nombre(nombre)
                        .apellido(apellido)
                        .nroTelefono(nroTelefono)
                        .email(email)
                        .dni(dni)
                        .rolId(parseIdList(rolId))
                        .build(),
                page
        );
    }

    @Override
    public Cliente get(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente create(Cliente cliente) {
        return clienteRepository.saveAndFlush(cliente);
    }

    @Override
    public Cliente update(Long id, Cliente cliente) {
        return clienteRepository.saveAndFlush(cliente);
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    public List<Long> parseIdList(String ids) {
        List<Long> idList = new ArrayList<>();
        if (ids != null && !ids.isEmpty()) {
            idList = Arrays.stream(ids.split(","))
                    .map(Long::parseLong)
                    .collect(Collectors.toList());
        }
        return idList;
    }

}
