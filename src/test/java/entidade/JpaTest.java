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
        
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Produto produto = new Produto();
        produto.setDescricao("NORMAL");
        em.persist(produto);
        
        ProdutoSimples produtoSimples = new ProdutoSimples();
        produtoSimples.setDescricao("SIMPLES");
        produtoSimples.setQuantidade(Quantidade.newInstance(10L));
        em.persist(produtoSimples);
        
        ProdutoComposto produtoComposto = new ProdutoComposto();
        produtoComposto.setDescricao("COMPOSTO");
        produtoComposto.setQuantidade(Quantidade.newInstance(5L));
        em.persist(produtoComposto);

        produto.setProdutoComposto(produtoComposto);
        
        Pedido pedido = new Pedido();
        pedido.addProduto(produto);
        pedido.addProduto(produtoComposto);
        pedido.addProduto(produtoSimples);
        em.persist(pedido);

        em.getTransaction().commit();
        em.close();

    }
}
