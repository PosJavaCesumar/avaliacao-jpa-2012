/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author rafik
 */
@Entity
@DiscriminatorValue("S")
public class SimpleProduct extends Product implements Serializable{
    
    @Column(name="manufacter")
    private String manufacter;

    public String getManufacter() {
        return manufacter;
    }

    public void setManufacter(String manufacter) {
        this.manufacter = manufacter;
    }
    
    
}
