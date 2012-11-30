
package entidade;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author zanoni
 */
@Entity
@DiscriminatorValue("C")
public class ProdutoComposto extends Produto implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name="produto_composto_id")
    private Long id;

     @Version
    private Integer version;
     
     @Column(length=255)
    private String observacao;
     
     @OneToMany(mappedBy="produtoComposto")
    private Set<Produto> produtos = new HashSet<Produto>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
}
