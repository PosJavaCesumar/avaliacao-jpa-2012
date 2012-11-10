package entidade;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Falci
 */
public class ProdutoComposto extends Produto{
    
    private Set<Produto> produtos = new HashSet<Produto>();
    
    public Set getProdutos(){
        return produtos;
    }
            
}
