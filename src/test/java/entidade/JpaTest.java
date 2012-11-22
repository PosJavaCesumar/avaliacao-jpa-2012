package entidade;

import com.mysema.query.jpa.impl.JPAQuery;
import java.util.List;
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

        ProdutoSimples produtoSimples = new ProdutoSimples();
        produtoSimples.setDescricao("OMO");
        produtoSimples.setFabricante("Unilever");
        produtoSimples.setPreco(4.98);
        entityManager.persist(produtoSimples);
      
        ProdutoComposto produtoComposto = new ProdutoComposto();
        produtoComposto.setComposicao("Poder O2");
        produtoComposto.setDescricao("Vanish");
        produtoComposto.setPreco(8.50);
        entityManager.persist(produtoComposto);
        
        ProdutoSimples produtoSimples2 = new ProdutoSimples();
        produtoSimples2.setDescricao("Ace");
        produtoSimples2.setFabricante("Unilever");
        produtoSimples2.setPreco(3.6);
        produtoSimples2.setProdutoComposto(produtoComposto);
        produtoComposto.getProdutos().add(produtoSimples2);
        produtoComposto.getProdutos().add(produtoSimples);
        entityManager.persist(produtoSimples2);

        Pedido pedido = new Pedido();
        pedido.setNomeCliente("Fernando");
        pedido.addProduto(produtoSimples);
        pedido.addProduto(produtoComposto);
        entityManager.persist(pedido);
        
        entityManager.getTransaction().commit();
        
    }

    
}
