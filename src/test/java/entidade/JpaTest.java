package entidade;

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
        
        ProdutoComposto produtoComposto = new ProdutoComposto();
        produtoComposto.setCodigo("PRO01");
        produtoComposto.setNome("Produto 01");
        produtoComposto.setPreco(12.45);
        produtoComposto.setObservacao("Esse é uma produto composto!");
        entityManager.persist(produtoComposto);
        
        ProdutoSimples produtoSimples = new ProdutoSimples();
        produtoSimples.setCodigo("PS01");
        produtoSimples.setNome("Produto Simples 01");
        produtoSimples.setPreco(34.66);
        produtoSimples.setDescricao("Esse é um produto simples!");
        entityManager.persist(produtoSimples);
        
        
        Pedido pedido = new Pedido();
        pedido.getProdutos().add(produtoComposto);
        entityManager.persist(pedido);
        
        entityManager.getTransaction().commit();
        
        
    }
}
