/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("C")
public class ProdutoComposto extends Produto {  
    
    @OneToMany(mappedBy = "produtoComposto", targetEntity = Produto.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)  
    private Set<Produto> produtos = new HashSet<Produto>();
    
    @Column(name="composicao", length=60)
    private String composicao;
    

    public String getComposicao() {
        return composicao;
    }

    public void setComposicao(String composicao) {
        this.composicao = composicao;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }
    
    

    
}
