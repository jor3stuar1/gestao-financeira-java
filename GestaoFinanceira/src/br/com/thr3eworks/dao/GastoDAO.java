/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.thr3eworks.dao;

import java.util.List;

import br.com.thr3eworks.model.Gasto;

/**
 *
 * @author Felipe Tavares
 */

public interface GastoDAO {

	public void save(Gasto gasto);
	public void update(Gasto gasto);
	public void remove(Gasto gasto);
	public Gasto find(Long ID);
	public List<Gasto> getGastos();
	public Long getCountGastos();
	
}
