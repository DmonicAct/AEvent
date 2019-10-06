package com.pucp.aevent.entity.request_objects;

public class PaginaRequest {
	private Integer pagina;
	private Integer registros;
	private String orden;
	
	public Integer getPagina() {
		return pagina;
	}
	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}
	public Integer getRegistros() {
		return registros;
	}
	public void setRegistros(Integer registros) {
		this.registros = registros;
	}
	
	public PaginaRequest() {
		this.pagina = 1;
		this.registros = 1;
		this.orden="DESCRIPCION";
	}
	
	public PaginaRequest(Integer pagina, Integer registros)
	{
		this.pagina = pagina;
		this.registros = registros;
	}
	public String getOrden() {
		return orden;
	}
	public void setOrden(String orden) {
		this.orden = orden;
	}
	public Integer getPaginaFront() {
		return pagina -1;
	}
}
