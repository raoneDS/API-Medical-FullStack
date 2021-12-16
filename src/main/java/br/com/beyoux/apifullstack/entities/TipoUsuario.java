package br.com.beyoux.apifullstack.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoUsuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private byte TipoUsuarioId;
	
	@Column(nullable = false)
	private String nomeCategoria;
	
	public TipoUsuario(byte tipoUsuarioId, String nomeCategoria) {
		TipoUsuarioId = tipoUsuarioId;
		this.nomeCategoria = nomeCategoria;
	}
	
	public byte getTipoUsuarioId() {
		return TipoUsuarioId;
	}
	public void setTipoUsuarioId(byte tipoUsuarioId) {
		TipoUsuarioId = tipoUsuarioId;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TipoUsuarioId;
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
		TipoUsuario other = (TipoUsuario) obj;
		if (TipoUsuarioId != other.TipoUsuarioId)
			return false;
		return true;
	}

}
