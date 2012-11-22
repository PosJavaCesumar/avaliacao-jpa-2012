/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType= DiscriminatorType.STRING, name="tipo", length=1)
public abstract class Produto implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(name="descricao", length=60)
    private String descricao;
    
    @Column(name="preco")
    private Double preco;
    
    @ManyToOne
    private Produto produtoComposto;
    
    @ManyToMany(mappedBy="produtos")
    private List<Pedido> pedidos = new LinkedList<Pedido>();

    public Produto getProdutoComposto() {
        return produtoComposto;
    }

    public void setProdutoComposto(Produto produtoComposto) {
        this.produtoComposto = produtoComposto;
    }
    
    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void addPedidos(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void setId(Long id) {
        this.id = id;
    }
}
