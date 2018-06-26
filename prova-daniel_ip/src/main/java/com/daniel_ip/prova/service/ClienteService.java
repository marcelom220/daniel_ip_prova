package com.daniel_ip.prova.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.daniel_ip.prova.dao.ClienteDAO;
import com.daniel_ip.prova.model.Cliente;
import com.daniel_ip.prova.util.Transactional;

public class ClienteService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClienteDAO clienteDAO;
	
	@Transactional
	public void salvar(Cliente cliente) {
		clienteDAO.salvar(cliente);
	}

	public void excluir(Cliente cliente) {
		clienteDAO.excluirCliente(cliente);
	}
	
	public List<Cliente> buscarClientes(String cpf, String nome){
		return clienteDAO.buscaCpfNome(cpf, nome);
	}
	
	public Cliente porId(Long id) {
		return clienteDAO.porId(id);
	}
}
