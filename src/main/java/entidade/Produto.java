package entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Falci
 */
@Entity
public class Produto {
    
    @Id
    @GeneratedValue
    private Long id;

    private String nome;
}
