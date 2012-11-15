package entidade;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType= DiscriminatorType.STRING, name="tipo", length=1)
@Table(name="tbl_produto")
public abstract class Produto implements Serializable{
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String dataDeEntrada;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="pedido_produto", 
            joinColumns=@JoinColumn(name="produto_fk"),
            inverseJoinColumns=@JoinColumn(name="pedido_fk"))
    private Set<Pedido> pedidos = new HashSet<Pedido>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataDeEntrada() {
        return dataDeEntrada;
    }

    public void setDataDeEntrada(String dataDeEntrada) {
        this.dataDeEntrada = dataDeEntrada;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    
}
