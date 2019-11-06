package com.pucp.aevent.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "division")
@NamedQueries({
    @NamedQuery(name = "Division.findAll", query = "SELECT d FROM Division d")})
public class Division implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_division")
    private Integer idDivision;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name="indice")
    private Integer indice;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    @JoinColumn(name = "id_formulariocfp")
    private FormularioCFP idFormulario;
    
    //mappedBy = "idDivision",
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name= "id_division")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Seccion> seccionList = new ArrayList<>();;

    public Division() {
    }
    
    public Division(Integer idDivision) {
        this.idDivision = idDivision;
    }
    
    public void addSeccion(Seccion seccion) {
        if (seccion != null) {
           if (this.seccionList == null) {
        	   seccionList = new ArrayList<Seccion>();          
           }
           seccionList.add(seccion);
           seccion.setDivision(this);
        }
     }
    
    public Integer getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(Integer idDivision) {
        this.idDivision = idDivision;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public FormularioCFP getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(FormularioCFP idFormulario) {
        this.idFormulario = idFormulario;
    }

    public List<Seccion> getSeccionList() {
        return seccionList;
    }

	public void setSeccionList(List<Seccion> seccionList) {
        this.seccionList = seccionList;
    }

    public Integer getIndice() {
		return indice;
	}

	public void setIndice(Integer indice) {
		this.indice = indice;
	}
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idDivision != null ? idDivision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Division)) {
            return false;
        }
        Division other = (Division) object;
        if ((this.idDivision == null && other.idDivision != null) || (this.idDivision != null && !this.idDivision.equals(other.idDivision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupoSCV.entidad.Division[ idDivision=" + idDivision + " ]";
    }
    
}
