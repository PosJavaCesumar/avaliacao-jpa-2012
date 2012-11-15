package entidade;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class ProdutoComposto extends Produto{
    
    private String nomeDoKit;
    
    private Float valor;

    public String getNomeDoKit() {
        return nomeDoKit;
    }

    public void setNomeDoKit(String nomeDoKit) {
        this.nomeDoKit = nomeDoKit;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
}
