package ed.coder.after2.service;


import ed.coder.after2.model.Cliente;
import ed.coder.after2.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente agregarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> buscarCliente(Long id) {
        return clienteRepository.findById(id);
    }
}
