package com.sistema.erp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sistema.erp.entidad.Cliente;
import com.sistema.erp.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClienteService {
	
	  private final ClienteRepository repos;

	    public ClienteService(ClienteRepository repos) {
	        this.repos = repos;
	    }
	public List<Cliente> Listar(){
		return (List<Cliente>) repos.findAll();
	}
	public Optional<Cliente> ListId(long id){
		return repos.findById(id);
	}
	public Cliente Edit(Cliente cliente) {
		return repos.save(cliente);
		
	}
	public void eliminarCliente(long id) {
		repos.deleteById(id);
	}
	public void AgregarCliente(Cliente cliente) {
		repos.save(cliente);
	}
	public long TotalClientes() {
		return repos.count();
	}
}
