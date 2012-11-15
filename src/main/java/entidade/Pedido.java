package entidade;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_pedido")
public class Pedido implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    
    private String setor;
    
    private String dataDoPedido;
    
    @ManyToMany(mappedBy="pedidos")
    private Set<Produto> produtos=new HashSet<Produto>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getDataDoPedido() {
        return dataDoPedido;
    }

    public void setDataDoPedido(String dataDoPedido) {
        this.dataDoPedido = dataDoPedido;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }
}
