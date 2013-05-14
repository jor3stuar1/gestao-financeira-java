package br.com.thr3eworks.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "GASTO")
@NamedQueries({
		@NamedQuery(name = "Gasto.findAll", query = "SELECT g FROM Gasto g ORDER BY g.tipo ASC"),
		@NamedQuery(name = "Gasto.count", query = "SELECT COUNT(g) FROM Gasto g") })
public class Gasto implements Serializable{

	
	/**
	 * 
	 */
	public Gasto() {
		this.capital = BigDecimal.ZERO;
	}
	
	private static final long serialVersionUID = -6710029683606442188L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="gastos_seq")
	@SequenceGenerator(name = "gastos_seq", sequenceName = "gastos_seq", allocationSize = 1)
	private Long idGastos;
	
	@Column(name = "tipoGastos", length = 30, nullable = false)
	private String tipo;
	
	@Column(name = "valorGastos", length = 12,  nullable = false)
	private BigDecimal valor;
	
	@Column(name = "descricaoGastos", length = 80)
	private String desc;
	
	@Column(name = "formaPagamento", length = 40, nullable = false)
	private String formaPagamento;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dataGastos", length = 60, nullable = false)
	private Date data;

	@Column(name="capital", length = 12)
	private BigDecimal capital;
	
	@ManyToOne
	private User users;

	
	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}
	
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public Long getIdGastos() {
		return idGastos;
	}

	public void setIdGastos(Long idGastos) {
		this.idGastos = idGastos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
	public String getDataFormatada() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		return formato.format(data);
		} 
	
	public BigDecimal getCapital() {
		return capital;
	}

	public void setCapital(BigDecimal capital) {
		this.capital = capital;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idGastos == null) ? 0 : idGastos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gasto other = (Gasto) obj;
		if (idGastos == null) {
			if (other.idGastos != null)
				return false;
		} else if (!idGastos.equals(other.idGastos))
			return false;
		return true;
	}
	
	
	
}
