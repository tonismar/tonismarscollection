/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mycollection;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author tonismar
 */
@Entity
@Table(name = "ITENS", catalog = "", schema = "APP")
@NamedQueries({@NamedQuery(name = "Itens.findAll", query = "SELECT i FROM Itens i"), @NamedQuery(name = "Itens.findByNome", query = "SELECT i FROM Itens i WHERE i.nome = :nome"), @NamedQuery(name = "Itens.findByTipo", query = "SELECT i FROM Itens i WHERE i.tipo = :tipo"), @NamedQuery(name = "Itens.findByVolume", query = "SELECT i FROM Itens i WHERE i.volume = :volume"), @NamedQuery(name = "Itens.findByDescricao", query = "SELECT i FROM Itens i WHERE i.descricao = :descricao")})
public class Itens implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @Column(name = "TIPO")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "VOLUME")
    private String volume;
    @Column(name = "DESCRICAO")
    private String descricao;

    public Itens() {
    }

    public Itens(String nome) {
        this.nome = nome;
    }

    public Itens(String nome, String tipo, String volume) {
        this.nome = nome;
        this.tipo = tipo;
        this.volume = volume;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        String oldTipo = this.tipo;
        this.tipo = tipo;
        changeSupport.firePropertyChange("tipo", oldTipo, tipo);
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        String oldVolume = this.volume;
        this.volume = volume;
        changeSupport.firePropertyChange("volume", oldVolume, volume);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nome != null ? nome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itens)) {
            return false;
        }
        Itens other = (Itens) object;
        if ((this.nome == null && other.nome != null) || (this.nome != null && !this.nome.equals(other.nome))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mycollection.Itens[nome=" + nome + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
