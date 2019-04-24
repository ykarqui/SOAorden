package ar.edu.iua.orden.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orden")
public class Orden {
	
	public Orden() {
		super();
	}

	public Orden(Integer idOrden, Integer idComprador, Integer idProducto, Boolean estado, String fecha,
			Double precio) {
		super();
		this.idOrden = idOrden;
		this.idComprador = idComprador;
		this.idProducto = idProducto;
		this.estado = estado;
		this.fecha = fecha;
		this.precio = precio;
	}

	//idOrden, idComprador, idProducto, estado, fecha, precio
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_orden", nullable = false)
	private Integer idOrden;
	
	@Column(name = "id_comprador")
	private Integer idComprador;
	
	@Column(name = "id_producto")
	private Integer idProducto;
	
	@Column(name = "estado")
	private Boolean estado;
	
	@Column(name = "fecha")
	private String fecha;
	
	@Column(name = "precio")
	private Double precio;

	public Integer getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(Integer idOrden) {
		this.idOrden = idOrden;
	}

	public Integer getIdComprador() {
		return idComprador;
	}

	public void setIdComprador(Integer idComprador) {
		this.idComprador = idComprador;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Orden [idOrden=" + idOrden + ", idComprador=" + idComprador + ", idProducto=" + idProducto + ", estado="
				+ estado + ", fecha=" + fecha + ", precio=" + precio + "]";
	}
	
	
	

}
