package entidade;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.hibernate.annotations.Type;

/**
 * @author Falci
 */
@Entity
@DiscriminatorValue("S")
public class ProdutoSimples extends Produto implements Serializable{

    @Type(type="text")
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}