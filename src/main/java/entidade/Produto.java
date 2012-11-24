package entidade;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType= DiscriminatorType.STRING, name="tipo", length=1)
@DiscriminatorValue("P")
public class Produto implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    
    @Column(length=50)
    private String descricao;
    
    @ManyToMany(mappedBy="produtos")
    private List<Pedido> pedidos = new LinkedList<Pedido>();

    @ManyToOne(optional=true)
    @JoinColumn(name = "produtoComposto_fk")
    private ProdutoComposto produtoComposto;
    
    @Version
    Integer version;

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Long getId(){
        return id;
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    public List<Pedido> getPedidos(){
        return pedidos;
    }

    public ProdutoComposto getProdutoComposto(){
        return produtoComposto;
    }
    
    public Produto() {
    }

    public void setProdutoComposto(ProdutoComposto produtoComposto) {
        this.produtoComposto = produtoComposto;
    }
}