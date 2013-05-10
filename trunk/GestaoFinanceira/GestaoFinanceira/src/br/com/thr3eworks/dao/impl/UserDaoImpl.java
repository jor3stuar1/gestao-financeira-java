package br.com.thr3eworks.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.thr3eworks.dao.UserDAO;
import br.com.thr3eworks.model.User;


@Repository
@Transactional
public class UserDaoImpl implements UserDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public User search(String name) {
		return entityManager.find(User.class, name);
	}

	@Override
	public void save(User user) {

		entityManager.persist(user);
	}

	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<User> getUsers() {
		return entityManager
				.createQuery("from User", User.class)
				.getResultList();
	}

	
}