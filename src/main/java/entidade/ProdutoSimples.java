package entidade;

import javax.persistence.Column;
import org.hibernate.annotations.Type;

/**
 * @author Falci
 */
public class ProdutoSimples extends Produto{

    @Type(type="text")
    private String descricao;
}