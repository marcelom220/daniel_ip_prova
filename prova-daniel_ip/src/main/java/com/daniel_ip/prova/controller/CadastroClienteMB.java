package com.daniel_ip.prova.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.daniel_ip.prova.model.Cliente;
import com.daniel_ip.prova.model.EstadoCivil;
import com.daniel_ip.prova.service.ClienteService;
import com.daniel_ip.prova.util.Transactional;

@Named
@ViewScoped
public class CadastroClienteMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private Cliente cliente = new Cliente();
	private Long idCliente;
	private List<EstadoCivil> estadoCivil;
	
	@Inject
	private ClienteService clienteService;
	
	public void inicializar() {
		if(idCliente != null) {
			cliente = clienteService.porId(idCliente);
		}
		estadoCivil = Arrays.asList(EstadoCivil.values());
	}
	
	
	public String salvar() {
		clienteService.salvar(cliente);
		return "lista-clientes.xhtml?faces-redirect=true";
	}
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public List<EstadoCivil> getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(List<EstadoCivil> estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
}
