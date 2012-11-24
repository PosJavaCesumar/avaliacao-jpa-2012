package entidade;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("C")
public class ProdutoComposto extends Produto {
    
    @OneToMany(mappedBy="produtoComposto")
    private List<Produto> produtos = new LinkedList<Produto>();
            
    @Column(name="quantidade")
    private Quantidade quantidade;
    
    public List<Produto> getProdutos(){
        return produtos;
    }
    
    public void setProdutos(List<Produto> produtos){
        this.produtos = produtos;
    }
    
    public void setQuantidade(Quantidade quantidade) {
        this.quantidade = quantidade;
    }

    public Quantidade getQuantidade() {
        return quantidade;
    }
}