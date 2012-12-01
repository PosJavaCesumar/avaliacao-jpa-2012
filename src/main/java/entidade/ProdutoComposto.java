
package entidade;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author zanoni
 */
@Entity
@DiscriminatorValue("C")
public class ProdutoComposto extends Produto {
   
     @Column(length=255)
    private String observacao;
     
    @OneToMany(orphanRemoval=true)//, mappedBy="produtoComposto")
    @JoinColumn(name="produtoComposto_id") 
    private Set<Produto> produtos = new HashSet<Produto>();



  
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }
    
    public void addProdutos(Produto produto) {
        this.produtos.add(produto);
    }

    @Override
    public String toString() {
        String desc = "\n"+getObservacao()+"\n";
        for (Produto produto : produtos) {
           desc = desc.concat(" - "+produto.toString()+"\n");
        }
        
        desc = desc.concat("===Fim produto composto===\n");
        return desc;
    }
    
    
}
