package entidade;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

@Entity
public class Pedido implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToMany
    @JoinTable(name = "pedido_produto", joinColumns = @JoinColumn(name = "pedido_fk"), 
            inverseJoinColumns = @JoinColumn(name = "produto_fk"))
    private List<Produto> produtos = new LinkedList<Produto>();

    @Version
    Integer version;
    
    public Pedido() {
    }
    
    public Long getId(){
        return id;
    }
    
    public List<Produto> getProdutos(){
        return produtos;
    }
    
    public void addProduto(Produto produto){
        produtos.add(produto);
    }
}
