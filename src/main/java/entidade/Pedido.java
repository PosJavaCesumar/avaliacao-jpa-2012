/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 *
 * @author zanoni
 */
@Entity
public class Pedido implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "pedido_id")
    private Long id;

    @Version
    private Integer version;
    
    @Column(name = "data_do_pedido")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    private DateTime data = new DateTime();
    
    @ManyToMany
    private Set<Produto> produtos  = new HashSet<Produto>();

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

   
    public DateTime getData() {
        return data;
    }

    public void setData(DateTime data) {
        this.data = data;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }
    
    public void showPedido(){
        System.out.println("Data: "+getData().toString("dd/MM/yyyy"));
        System.out.println("Pedido n.: "+getId());
        for (Produto produto : getProdutos()) {
            System.out.println(produto);
        }
            
                
    }

    @Override
    public String toString() {
        String texto =" Pedido n.: "+getId()+"\n"+
                "Data: "+getData().toString("dd/MM/yyyy")+"\n";
        for (Produto produto : getProdutos()) {
            texto = texto.concat(produto.toString());
        }
        texto = texto.concat("\n--- Fim do Pedido ---\n");
        return texto;
    }
}
