/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mycollection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.client.am.Statement40;

/**
 *
 * @author tonismar
 */
public class ItemModel {
    private String nome;
    private String tipo;
    private String volume;
    private String descricao;
    private Exception e;
    private DBConnection resource;
    private ResultSet rs;
    private Statement stm;

    public ItemModel() {
        try {
            this.resource = new DBConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ItemModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        //if( nome.length() <= 50 ){
            this.nome = nome;
        //} else {
          //  e = new Exception("Tamanho do campo superior a 50 caracteres.");
        //}
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the volume
     */
    public String getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(String volume) {
        this.volume = volume;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        if( descricao.length() <= 254 ){
            this.descricao = descricao;
        } else {
            e = new Exception("Tamanho do campo superior a 254 caracteres.");
        }
    }

    public void add(){
        String query = "INSERT INTO itens VALUES ('" + this.getNome() + "','" + this.getTipo() + "','" + this.getVolume() + "','" + this.getDescricao() + "')";
        resource.executeSQL(query);
    }

    public ResultSet find() {
        String query = "Select tipo, nome from itens where nome like '%" + this.getNome() + "%'";
        try {
            this.rs = this.stm.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(ItemModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.rs;
    }

}