package entidade;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @author Falci
 */
@Entity
public class Pedido implements Serializable{
    
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToMany
    private Set<Produto> produtos = new HashSet<Produto>();
    
    public Set getProdutos(){
        return produtos;
    }
    
    
}
