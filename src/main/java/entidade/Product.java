/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author rafik
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "type", length = 1)
public abstract class Product implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    
    private Double price;
    
    @ManyToMany(mappedBy="products")
    private List<Sales> productSales = new LinkedList<Sales>();

    @ManyToMany(mappedBy="products")
    private List<ComposedProduct> composedsProducts = new LinkedList<ComposedProduct>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sales> getPedidos() {
        return productSales;
    }

    public void setPedidos(List<Sales> pedidos) {
        this.productSales = pedidos;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Sales> getProductSales() {
        return productSales;
    }

    public void setProductSales(List<Sales> productSales) {
        this.productSales = productSales;
    }
}
