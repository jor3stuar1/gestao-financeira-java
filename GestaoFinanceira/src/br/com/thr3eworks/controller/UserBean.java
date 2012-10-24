package br.com.thr3eworks.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.thr3eworks.dao.UserDAO;
import br.com.thr3eworks.model.User;


@Controller
@ManagedBean
@Scope("request")
public class UserBean {
	private List<User> users = new ArrayList<User>();
	private User user = new User();
	private UserDAO userDAO;

	public UserBean() {
		
	}

	@Autowired
	public UserBean(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public List<User> getUsers() {
		this.users = userDAO.getUsers();
		return this.users;
	}

	public void save() {

		userDAO.save(this.user);
		user = new User();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}