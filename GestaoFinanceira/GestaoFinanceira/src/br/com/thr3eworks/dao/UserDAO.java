/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.thr3eworks.dao;

import java.util.List;

import br.com.thr3eworks.model.User;

/**
 *
 * @author Felipe Tavares
 */

public interface UserDAO {

	public User search(String name);
	public void save(User user);
	public List<User> getUsers();
	
}
