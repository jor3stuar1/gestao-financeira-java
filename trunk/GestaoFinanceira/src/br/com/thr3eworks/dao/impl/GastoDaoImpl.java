package br.com.thr3eworks.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.thr3eworks.dao.GastoDAO;
import br.com.thr3eworks.model.Gasto;


@Repository
@Transactional
public class GastoDaoImpl implements GastoDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Gasto gasto) {
		
		entityManager.merge(gasto);
		entityManager.flush();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void update(Gasto gasto) {
		entityManager.merge(gasto);
	}

	@Override
	public void remove(Gasto gasto) {
		entityManager.remove(gasto);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public Gasto find(Long ID) {
		return entityManager.find(Gasto.class, ID);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<Gasto> getGastos() {
		return this.entityManager.createNamedQuery("Gasto.findAll")
				.getResultList();
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public Long getCountGastos() {
		return (Long) this.entityManager.createNamedQuery("Gasto.count")
				.getSingleResult();
	}

	
}
