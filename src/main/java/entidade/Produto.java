package entidade;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author Falci
 */
@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType= DiscriminatorType.STRING, name="tipo", length=1)
public class Produto implements Serializable{
    
    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    
    @ManyToOne
    private ProdutoComposto produtoComposto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ProdutoComposto getProdutoComposto() {
        return produtoComposto;
    }

    public void setProdutoComposto(ProdutoComposto produtoComposto) {
        this.produtoComposto = produtoComposto;
    }
    
}
