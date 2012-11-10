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
        produtoComposto.setNome("Grupo de Produtos 1");
        entityManager.persist(produtoComposto);
        
        ProdutoSimples produto = new ProdutoSimples();
        produto.setNome("Produto 1");
        produto.setDescricao("Descrição do Produto 1");
        produto.setProdutoComposto(produtoComposto);
        entityManager.persist(produto);
        
        Pedido pedido = new Pedido();
        pedido.getProdutos().add(produtoComposto);
        entityManager.persist(pedido);
        
        entityManager.getTransaction().commit();
    }
}
