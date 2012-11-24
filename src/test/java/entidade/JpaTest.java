package entidade;

import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.BeforeClass;
import org.junit.Test;

public class JpaTest {

    private static EntityManagerFactory emf;

    @BeforeClass
    public static void init() {
        emf = Persistence.createEntityManagerFactory("jpaPU");
    }

    @Test
    public void test() {
        EntityManager entityManager = emf.createEntityManager();
 	 
        entityManager.getTransaction().begin();
        
        SimpleProduct sProduct1 = new SimpleProduct();
        sProduct1.setName("Picanha" + System.currentTimeMillis());
        sProduct1.setPrice(20D);
        sProduct1.setManufacter("JBS");
        entityManager.persist(sProduct1);
        
        SimpleProduct sProduct2 = new SimpleProduct();
        sProduct2.setName("Cerveja" + System.currentTimeMillis());
        sProduct2.setPrice(90D);
        sProduct2.setManufacter("AntarticaOriginal");
        entityManager.persist(sProduct2);
        
        SimpleProduct sProduct3 = new SimpleProduct();
        sProduct3.setName("Carvao" + System.currentTimeMillis());
        sProduct3.setPrice(10D);
        sProduct3.setManufacter("Lingua Quente");
        entityManager.persist(sProduct3);

        ComposedProduct cProduct = new ComposedProduct();
        cProduct.setName("Churrasco" + System.currentTimeMillis());
        cProduct.setPrice(110D);
        cProduct.setDescription("Junção Perfeita");
        cProduct.getProducts().add(sProduct1);
        cProduct.getProducts().add(sProduct2);
        entityManager.persist(cProduct);
        
        Sales sale = new Sales();
        sale.setCustomer("Pós Java 2012" + System.currentTimeMillis());
        sale.setSalesDate(new GregorianCalendar().getTime());
        sale.getProducts().add(cProduct);
        sale.getProducts().add(sProduct3);
        entityManager.persist(sale);
        
        entityManager.getTransaction().commit();
    }
}
