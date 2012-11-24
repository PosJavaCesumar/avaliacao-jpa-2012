/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author rafik
 */
@Entity
@DiscriminatorValue("C")
public class ComposedProduct extends Product implements Serializable{
    
    @Column(name="description")
    private String description;
    
    @ManyToMany
    @JoinTable(name="composedproductitems")
    private List<Product> products = new LinkedList<Product>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    
}
