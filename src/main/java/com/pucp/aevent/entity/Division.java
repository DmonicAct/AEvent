package com.pucp.aevent.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    
    @JsonIgnore
    @JoinColumn(name = "id_formulario", referencedColumnName = "idFormularioCFP")
    @ManyToOne
    private FormularioCFP idFormulario;
    
    @OneToMany(mappedBy = "idDivision",cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Seccion> seccionList;

    public Division() {
    }

    public Division(Integer idDivision) {
        this.idDivision = idDivision;
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
