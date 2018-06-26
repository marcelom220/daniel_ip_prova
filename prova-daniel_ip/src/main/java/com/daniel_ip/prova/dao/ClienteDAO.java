package com.daniel_ip.prova.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.daniel_ip.prova.model.Cliente;
import com.daniel_ip.prova.util.exception.ApplicationException;

public class ClienteDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public Cliente salvar(Cliente cliente) {
		return em.merge(cliente);
	}

	public void excluirCliente(Cliente cliente) {
		cliente = porId(cliente.getId());
		try {
			em.remove(cliente);
			em.flush();
		} catch (Exception e) {
			throw new ApplicationException("Erro ao excluir cliente");
		}
	}

	public Cliente porId(Long id) {
		return em.find(Cliente.class, id);
	}

	public List<Cliente> buscaCpfNome(String cpf, String nome) {
		String clientes = "select c FROM Cliente c WHERE 1 = 1";
		if (!cpf.equals("")) {
			clientes += " and c.cpf = :cpf";
		}
		if (!nome.equals("")) {
			clientes += " and UPPER(c.nome) LIKE :nome";
		}
		Query query = em.createQuery(clientes);
		if (!cpf.equals("")) {
			query.setParameter("cpf", cpf);
		}
		if (!nome.equals("")) {
			query.setParameter("nome", "%"+nome.toUpperCase()+"%");
		}
		return query.getResultList();
	}

}
