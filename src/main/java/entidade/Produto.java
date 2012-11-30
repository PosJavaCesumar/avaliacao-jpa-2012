/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

/**
 *
 * @author zanoni
 */
@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType= DiscriminatorType.STRING, name="tipo", length=1)
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name="produto_id")
    private Long id;
    
    @Column(length=5)
    private String codigo;
    
    @Column(nullable=false)
    private String nome;
    
    @Column(nullable=false)
    private Double preco;
    
    @ManyToOne
    private ProdutoComposto produtoComposto;

    public ProdutoComposto getProdutoComposto() {
        return produtoComposto;
    }

    public void setProdutoComposto(ProdutoComposto produtoComposto) {
        this.produtoComposto = produtoComposto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
