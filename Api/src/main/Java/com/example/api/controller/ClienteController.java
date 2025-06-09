package com.example.api.controller;

import com.example.api.model.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private List<Cliente> clientes = new ArrayList<>();
    private AtomicLong contadorId = new AtomicLong(1);

    public ClienteController() {
        clientes.add(new Cliente(4382L, "Leonardo Dias", "27 420956489", "leonardo@email.com"));
        clientes.add(new Cliente(7251L, "Amara Hoffmann", "11 428429842", "amara@email.com"));
        clientes.add(new Cliente(3197L, "Armando Ferrari", "27 669334200", "armando@gmail.com"));
        clientes.add(new Cliente(8924L, "Juscelino Kubitschek", "11 489842948", "juscelino@gmail.com"));
    }

    @GetMapping
    public List<Cliente> listar() {
        return clientes;
    }

    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente) {
        cliente.setId(contadorId.getAndIncrement());
        clientes.add(cliente);
        return cliente;
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                cliente.setNome(clienteAtualizado.getNome());
                cliente.setTelefone(clienteAtualizado.getTelefone());
                cliente.setEmail(clienteAtualizado.getEmail());
                return cliente;
            }
        }
        throw new RuntimeException("Cliente não encontrado com id: " + id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        boolean removido = clientes.removeIf(cliente -> cliente.getId().equals(id));
        if (!removido) {
            throw new RuntimeException("Cliente não encontrado com id: " + id);
        }
    }
}

