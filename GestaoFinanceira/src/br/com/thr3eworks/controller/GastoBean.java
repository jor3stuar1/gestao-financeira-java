package br.com.thr3eworks.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.thr3eworks.dao.GastoDAO;
import br.com.thr3eworks.dao.UserDAO;
import br.com.thr3eworks.model.Gasto;
import br.com.thr3eworks.model.User;

@Controller
@ManagedBean
@ViewScoped
public class GastoBean {
	
	private Gasto gasto = new Gasto();
	private List<Gasto> gastos =new ArrayList<Gasto>();
	private String generoID;
	
	public GastoBean() {
	
	}
	
	@Autowired
	public GastoBean(GastoDAO gastoDAO,UserDAO userDAO,User user) {
		this.gastoDAO = gastoDAO; 
		this.userDAO = userDAO;
		this.user = user;
	}
	
	private GastoDAO gastoDAO;
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	private UserDAO userDAO;
	private User user;
	
	public void save() {
		
		this.user = userDAO.search(generoID);
		this.gasto.setUsers(this.user);
		Date d = gasto.getData();
		SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
		try {
			d= sp.parse(sp.format(d));

			System.out.println("Formate:"+sp.format(d));
			System.out.println(sp.parse(sp.format(d)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		gasto.setData(d);
		gastoDAO.save(this.gasto);
		
		
		this.gasto = new Gasto();
		this.generoID = null;
		this.gastos = null;
	}

	public void update() {
	    
	    Date d = gasto.getData();
		SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
		sp.format(d);
		gasto.setData(d);
		gastoDAO.update(gasto);
		
		gasto = new Gasto();
		generoID = null;
		gastos = null;

	}

	public void remove(Gasto gasto) {
		gastoDAO.remove(gasto);
	}

	public List<Gasto> getGastos() {
		this.gastos = gastoDAO.getGastos();
		return this.gastos;
	}

	public Long getCount() {
		return gastoDAO.getCountGastos();
	}

	public void preparaAlterar(Gasto gasto) {
		 this.gasto = gastoDAO.find(gasto.getIdGastos());
		 this.generoID = this.getGasto().getUsers().getUsername();
	     
		//return "index?faces-redirect=true";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Gasto getGasto() {
		return gasto;
	}

	public void setGasto(Gasto Gasto) {
		this.gasto = Gasto;
	}

	public String getGeneroID() {
		return generoID;
	}

	public void setGeneroID(String generoID) {
		this.generoID = generoID;
	}
	public GastoDAO getGastoDAO() {
		return gastoDAO;
	}
	public void setGastoDAO(GastoDAO GastoDAO) {
		this.gastoDAO = GastoDAO;
	}

	public void setGastos(List<Gasto> Gastos) {
		this.gastos = Gastos;
	}

}