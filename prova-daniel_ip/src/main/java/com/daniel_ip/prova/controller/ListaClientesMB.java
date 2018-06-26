package com.daniel_ip.prova.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.daniel_ip.prova.model.Cliente;
import com.daniel_ip.prova.model.EstadoCivil;
import com.daniel_ip.prova.service.ClienteService;
import com.daniel_ip.prova.util.FacesUtil;
import com.daniel_ip.prova.util.Transactional;

@Named
@ViewScoped
public class ListaClientesMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ClienteService clienteService;
	private List<Cliente> clientes = new ArrayList<>();
	private List<Cliente> clientesSelecionados = new ArrayList<>();
	private Cliente clienteSelecionado = new Cliente();
	private List<EstadoCivil> estadoCivil;
	private String cpf = "";
	private String nome = "";

	
	public void inicializar() {
		pesquisar();
		estadoCivil = Arrays.asList(EstadoCivil.values());
	}

	@Transactional
	public void excluirSelecionados() {
		for (Cliente c : clientesSelecionados) {
			clienteService.excluir(c);
			clientes.remove(c);
		}
		FacesUtil.addInfoMessage("Cliente(s) excluído(s) com sucesso!");
		 
	}
	
	public void pesquisar() {
		clientes = clienteService.buscarClientes(cpf, nome);
	}
	@Transactional
	public void excluir() {
		clienteService.excluir(clienteSelecionado);
		clientes.remove(clienteSelecionado);
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Cliente> getClientesSelecionados() {
		return clientesSelecionados;
	}

	public void setClientesSelecionados(List<Cliente> clientesSelecionados) {
		this.clientesSelecionados = clientesSelecionados;
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public List<EstadoCivil> getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(List<EstadoCivil> estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
