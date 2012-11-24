package entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("S")
public class ProdutoSimples extends Produto {
    
    @Column(name="quantidade")
    private Quantidade quantidade;
    
    public Quantidade getQuantidade(){
        return quantidade;
    }
    
    public void setQuantidade(Quantidade quantidade){
        this.quantidade = quantidade;
    }
}