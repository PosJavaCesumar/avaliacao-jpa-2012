package entidade;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * @author Falci
 */
@Entity
@DiscriminatorValue("C")
public class ProdutoComposto extends Produto implements Serializable{
    
    @OneToMany(mappedBy="produtoComposto")
    private Set<Produto> produtos = new HashSet<Produto>();
    
    public Set getProdutos(){
        return produtos;
    }
            
}
